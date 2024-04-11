const dropdownBtn = document.getElementById("dropdownHoverButton");
const dropdownMenu = document.getElementById("dropdownHover");

export function dropdownHoverEnter() {
  console.log("mouseenter event triggered");
  dropdownBtn.addEventListener("mouseenter", () => {
    console.log("mouseenter on dropdown button");
    dropdownMenu.classList.remove("hidden");
    document.getElementById("arrow").classList.remove("hidden");
  });
}

export function dropdownHoverLeave() {
  console.log("mouseleave event triggered");
  dropdownBtn.addEventListener("mouseleave", () => {
    console.log("mouseleave on dropdown button");
    dropdownMenu.classList.add("hidden");
    document.getElementById("arrow").classList.add("hidden");
  });
}

export function dropdownHoverMenuEnter() {
  console.log("mouseenter event triggered on dropdown menu");
  dropdownMenu.addEventListener("mouseenter", () => {
    console.log("mouseenter on dropdown menu");
    dropdownMenu.classList.remove("hidden");
  });
}

export function dropdownHoverMenuLeave() {
  console.log("mouseleave event triggered on dropdown menu");
  dropdownMenu.addEventListener("mouseleave", () => {
    console.log("mouseleave on dropdown menu");
    dropdownMenu.classList.add("hidden");
  });
}
