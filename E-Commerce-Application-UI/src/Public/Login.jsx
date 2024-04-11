import React from 'react';

const Login = () => {
  return  <div id='login' className='flex border-black border-solid border-2 w-[800px] h-[400px]'>
    
<div id='loginsec1' className='h-[400px]  w-[400px] flex justify-around items-center italic bg-blue-600 border-black border-solid border-2 '>
<p className='text-white text-2xl font-bold'>FlipKart</p>
</div>
<div id='loginsec2' className='h-[400px]  w-[400px] flex flex-col justify-around items-center border-black border-solid border-2 '> 
 <div id="para" className=''><p>Login</p></div>
 <div id='inputbox' className=' flex flex-col justify-around items-center text-sm h-[100px] w-[200px]'><p className='mr-20'>Enter Username</p><input id='username' className=' rounded-full border-blue-200 border-2 border-solid mt- gap-2 w-[200px] h-[30px]' placeholder='username@gmail.com'/>
 <p className='mr-20'>Enter a Password</p><input id="password" className='rounded-full  w-[200px] h-[30px] border-blue-200 border-2 border-solid ' placeholder='********'/>
 </div>
 <div><button className='bg-blue-500 h-[30px] w-[80px] rounded-full'>Login</button></div>
 </div>;
 </div>
  };

export default Login