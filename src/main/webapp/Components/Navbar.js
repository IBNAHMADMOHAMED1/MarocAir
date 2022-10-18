export default class Navbar extends HTMLElement {
    constructor() {
        super();
    }

    connectedCallback() {
        this.innerHTML = `
       
        <h1>deed</h1>
        `;
    }
}
customElements.define("nav-component", Navbar);

