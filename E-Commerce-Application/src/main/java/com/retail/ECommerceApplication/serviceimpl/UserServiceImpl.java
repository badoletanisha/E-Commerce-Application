package com.retail.ECommerceApplication.serviceimpl;

import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.retail.ECommerceApplication.cache.CacheStore;
import com.retail.ECommerceApplication.entity.Customer;
import com.retail.ECommerceApplication.entity.Seller;
import com.retail.ECommerceApplication.entity.User;
import com.retail.ECommerceApplication.enums.userRole;
import com.retail.ECommerceApplication.exception.InvalidOtpException;
import com.retail.ECommerceApplication.exception.InvalidUserRoleException;
import com.retail.ECommerceApplication.exception.OtpExpiredException;
import com.retail.ECommerceApplication.exception.RegistrationSessionExpiredException;
import com.retail.ECommerceApplication.exception.UserExistedByEmailException;
import com.retail.ECommerceApplication.mail_service.MailService;
import com.retail.ECommerceApplication.mail_service.MessageModel;
import com.retail.ECommerceApplication.repository.UserRepository;
import com.retail.ECommerceApplication.requestdto.OtpRequest;
import com.retail.ECommerceApplication.requestdto.UserRequest;
import com.retail.ECommerceApplication.responsedto.UserResponse;
import com.retail.ECommerceApplication.service.UserService;
import com.retail.ECommerceApplication.utility.ResponseStructure;
import com.retail.ECommerceApplication.utility.SimpleResponseStructure;

import jakarta.mail.MessagingException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	private CacheStore<String> otpCache;
	private CacheStore<User> userCache;
	private ResponseStructure<UserResponse> responseStructure;
	private SimpleResponseStructure simpleResponse;
	private MailService mailService;

	@Override
	public ResponseEntity<SimpleResponseStructure> userRegistration(UserRequest userReqeust) {

		if (userRepository.existsByEmail(userReqeust.getEmail()))
			throw new UserExistedByEmailException("invalid user");

		User user = mapToChildEntity(userReqeust);
		String otp = generatedOTP();

		otpCache.add(userReqeust.getEmail(), otp);
		userCache.add(userReqeust.getEmail(), user);

		System.err.print(otp);

		//		send mail with otp
		try {
			sendMail(user,otp);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//		return user data
		return ResponseEntity.ok(simpleResponse.setSatuscode(HttpStatus.ACCEPTED.value())
				.setMessage("varify OTP sent though mail to comliete registration" + "OTP Expire in 1 minute"));
	}

	private void sendMail(User user, String otp) throws MessagingException{
		MessageModel messageModel = MessageModel.builder().to(user.getEmail())
		.subject("Varify Your OTP")
		.text(

				"<p> Hi,<br>"
						+"Thanks for your intrest in E-Commerce-Application"
						+"please verify your mail ID using the otp given below.</p>"
						+"<br>"
						+ "<h1>"+otp+"</h1>"
						+"<br>"
						+"<p>please ignore if its not you</p>"
						+"<br>"
						+"with best regards"
						+"<h3>E-Commerce-Application</h3>"
						+"<img src='https://i.postimg.cc/136S0Pjc/iphone.jpg'/>"
				)
		.build();
		mailService.sendMailMessage(messageModel);
	}


	private String generatedOTP() {
		return String.valueOf(new Random().nextInt(100000, 999999));
	}

	@SuppressWarnings("unchecked")
	private <T extends User> T mapToChildEntity(UserRequest userReqeust) {
		userRole role = userReqeust.getUserRole();
		User user = null;
		switch (role) {
		case SELLER -> user = new Seller();
		case CUSTOMER -> user = new Customer();
		default -> throw new InvalidUserRoleException(" invalid user");
		}

		user.setDisplayName(userReqeust.getName());
		user.setUsername(userReqeust.getEmail().split("@gmai.com")[0]);
		user.setEmail(userReqeust.getEmail());
		user.setPassword(userReqeust.getPassword());
		user.setUserRole(role);
		user.setEmailVerified(false);
		user.setDelete(false);
		return (T) user;
	}

	@Override
	public ResponseEntity<ResponseStructure<UserResponse>> verifyOTP(OtpRequest otpRequest) {
		if (otpCache.get(otpRequest.getEmail()) == null)
			throw new OtpExpiredException(" otp expire");
		if (!otpCache.get(otpRequest.getEmail()).equals(otpRequest.getOtp()))
			throw new InvalidOtpException("invalid otp");

		User user = userCache.get(otpRequest.getEmail());
		if (user == null)
			throw new RegistrationSessionExpiredException(" Registration Timeout Try Again");
		user.setEmailVerified(true);

		return ResponseEntity.ok(responseStructure.setStatuscode(HttpStatus.CREATED.value())
				.setMessage("otp genrated successfully").setData(mapToUserResponse(user)));
	}

	private UserResponse mapToUserResponse(User user) {
		return UserResponse.builder().displayName(user.getDisplayName()).userId(user.getUserId())
				.username(user.getUsername()).email(user.getEmail()).isDelete(user.isDelete())
				.isEmailVerified(user.isEmailVerified()).userRole(user.getUserRole()).build();

	}



}         



























//	private Seller mapToSellerEntity(UserRequest userReqeust, Seller seller) {
//		String email =userReqeust.getEmail();
//		seller.setEmail(email);
//		seller.setUsername(email.substring(0, email.indexOf("@")));
//		seller.setPassword(userReqeust.getPassword());
//		seller.setDisplayName(userReqeust.getName());
//		seller.setEmailVerified(false);
//		seller.setDelete(false);
//		return seller;
//	}

//	private Customer mapToCustomerEntity(UserRequest userReqeust, Customer customer) {
//
//		String email =userReqeust.getEmail();
//		customer.setEmail(email);
//		customer.setDelete(false);
//		customer.setEmailVerified(false);
//		customer.setUsername(email.substring(0,email.indexOf("@")));
//		customer.setPassword(userReqeust.getPassword());
//		customer.setDisplayName(userReqeust.getName());
//		customer.setUserRole(userReqeust.getUserRole());
//		return customer;
//	}
//
//}
