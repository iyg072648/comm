class UserService{
    static #instance = null;
    static getInstance(){
        if(this.#instance == null){
            this.#instance = new PrincipalApi();
        }
        return this.#instance;
    }
}