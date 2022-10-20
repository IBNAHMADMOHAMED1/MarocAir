export default class Navbar extends HTMLElement {
    constructor() {
        super();
    }

    connectedCallback() {
        this.innerHTML = `
       <div class="w-full h-[70px] bg-white flex justify-around">
        <div class="bg-blue-400">
            <h1>Logo</h1>
        </div>
        <div class="w-3/4 h-full flex justify-around items-center">
            <div class="w-1/2">
                <ul class="flex justify-evenly items-center  w-full h-full">
                    <li>
                        <a href="" style="font-family: 'Poppins', sans-serif">HOME</a>
                    </li>
                    <li>
                        <a href="" style="font-family: 'Poppins', sans-serif">Your Cart</a>
                    </li>
                    <li>
                        <a href="" style="font-family: 'Poppins', sans-serif">Favourites</a>
                    </li>
                </ul>
            </div>
            <div class="w-1/4 flex justify-end items-end">
                <div class="w-1/2 flex items-center justify-around">
                    <a href="#" style="font-family: 'Poppins', sans-serif">Login</a>

                    <a href="#" style="font-family: 'Poppins', sans-serif">Sign up</a>
                </div>
            </div>
        </div>
    </div>
        `;
    }
}
customElements.define("nav-component", Navbar);

