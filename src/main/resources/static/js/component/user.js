class UserService{
    static #instance = null;
    static getInstance(){
        if(this.#instance == null){
            this.#instance = new PrincipalApi();
        }
        return this.#instance;
    }

    loadUser(){
        const userContainer = document.querySelector(".user-container")
        const principal = PrincipalApi.getInstance().getPrincipal();

        userContainer.innerHTML = `
            <ul class="account-container">
                ${principal == null 
                    ? `
                    <a href="/account/register">회원 가입</a>
                    <a href="/account/login">로그인</a>
                    `
                    : `
                    <a href="#">${principal.user.name}</a>
                    <a href="/board/save">글쓰기</a>
                    <a href="/board/list">글목록</a>
                    <a href="/logout">로그아웃</a>
                    `
                }
            </ul>
        
        `;
    }
}