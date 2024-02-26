import { ajaxRequest } from "./request.js";
import { createInitializer } from "./initializer.js";

let hash = window.location.hash
let path = hash.substring(1);
let html = '';

/*
초기 실행 메서드
*/
const initialize = createInitializer();
initialize.addCustomFunctionHandlebars();
const initialize2 = createInitializer();
initialize2.addCustomFunctionHandlebars();

jQuery.validator.addMethod("phone", function(phone_number, element) {
    phone_number = phone_number.replace(/\s+/g, "");
    return this.optional(element) || phone_number.length > 9 && phone_number.match(/010-\d{4}-\d{4}$/);
});

jQuery.validator.addMethod("resident", function(resident_number, element) {
	resident_number = resident_number.replace(/\s+/g, "");

	return this.optional(element) || resident_number.length > 13 && resident_number.match(/^\d{6}-\d{7}$/);
});


function showSignupForm() {
	const signupForm = $('.js-validate');
	initialize.validatorUserWriteFormSetDefault();
	let validator = signupForm.validate();
	initialize.setValidator(validator);
}

$(document).ready(function() {
	const userUpdateForm = $('.userUpdate-validate');
	let href = window.location.href;
	let userInfoHref = href.substring(href.lastIndexOf('/') + 1);
	
	if (userInfoHref == 'userInfo') {
		initialize2.validatorUserUpdateFormSetDefault();
		let validator = userUpdateForm.validate();
		initialize2.setValidator(validator);	
	}
	
});

function init() {
	registEvent();
	navigate();
}

/*
이벤트 등록
*/
function registEvent() {

	$('#userForm').keypress(function(e) {
		if ($(e.target).hasClass('loginEnter')) {
			if (e.keyCode == 13) {
				window.location.hash = '#/login'
			}
		}
	});

	/*
	$(window).on('load', function(e) {
		alert('load  event:' + e);
	});
	*/
	$(window).on('hashchange', function(e) {
		//alert('hashchange event:' + e);
		hash = window.location.hash
		path = hash.substring(1);
		navigate();
	});
	
	$('#signup').on('transitionend', function () {
        if ($(this).css('display') === 'block') {
            showSignupForm();
        }
    });
	
	$(document).on('keydown',function(e){
		if(e.keyCode === 13){
			if($(e.target).hasClass('loginButton')){
				alert('dd');
			}
		}
		
	});
	
	$(document).on('click', function(e) {
		hash = window.location.hash;
		path = hash.substring(1);

		if (e.target.getAttribute('data-navigate') == '#/login') {
			if (window.location.hash.substring(1) == e.target.getAttribute('data-navigate')) {
				navigate();
			}
		}

		/******************** 아이디 찾기 ********************/
		if ($(e.target).hasClass('findIdBtn')) {

			let userName = $('#userName').val();
			let userResident = $('#userResident').val();

			let send = {
				userName: userName,
				userResident: userResident
			}

			let response = ajaxRequest('post', 'user/findId', send);

			if (typeof response.message === 'undefined') {
				$('.notFoundId').remove();
				$('.findId').remove();

				var findIdContainer = document.getElementById("findIdContainer");
				var newSpan = document.createElement("span");
				var br = document.createElement("br");
				br.className = 'findId';
				newSpan.textContent = '* 아이디'
				newSpan.className = "findId";
				findIdContainer.appendChild(newSpan);
				findIdContainer.appendChild(br);

				for (let i = 0; i < response.userId.length; i++) {
					// 새로운 span 엘리먼트 생성
					var newSpan = document.createElement("span");
					var br = document.createElement("br");

					// 생성한 span에 속성 및 내용 설정
					newSpan.textContent = '- ' + response.userId[i];
					newSpan.className = "findId";
					br.className = 'findId';

					// findIdContainer에 새로운 span 추가
					var findIdContainer = document.getElementById("findIdContainer");
					findIdContainer.appendChild(newSpan);
					findIdContainer.appendChild(br);
				}
				
				$('#findIdContainer').removeClass();

			} else {
				$('.findId').remove();
				$('.notFoundId').remove();

				var newSpan = document.createElement("span");

				// 생성한 span에 속성 및 내용 설정
				newSpan.textContent = response.message
				newSpan.style.color = 'red';
				newSpan.className = "notFoundId";

				// findIdContainer에 새로운 span 추가
				var findIdContainer = document.getElementById("findIdContainer");
				findIdContainer.appendChild(newSpan);
			}
		}

		/******************** 비밀번호 찾기 ********************/
		if ($(e.target).hasClass('findPasswordBtn')) {

			let userId = $('#userId').val();
			let userResident = $('#userResident2').val();

			let send = {
				userId: userId,
				userResident: userResident
			}
			console.log(send);
			let response = ajaxRequest('post', 'user/findPassword', send);

			if (typeof response.message === 'undefined') {
				$('.notFoundPassword').remove();
				$('.findPassword').remove();

					var newSpan = document.createElement("span");
					var br = document.createElement("br");

					newSpan.textContent = '* 비밀번호 : ' + response.userPassword;
					newSpan.className = "findPassword";

					var findPasswordContainer = document.getElementById("findPasswordContainer");
					findPasswordContainer.appendChild(newSpan);
				

				$('#findPasswordContainer').removeClass();

			} else {
				$('.findPassword').remove();
				$('.notFoundPassword').remove();

				var newSpan = document.createElement("span");

				newSpan.textContent = response.message;
				newSpan.style.color = 'red';
				newSpan.className = "notFoundPassword";

				var findPasswordContainer = document.getElementById("findPasswordContainer");
				findPasswordContainer.appendChild(newSpan);
			}
		}
		
		/******************** 회원 가입 ********************/
		const signupForm = $('.js-validate');
		if ($(e.target).hasClass('userRegisterBtn')) {
			if (signupForm.valid()) {
			
			let userId = $('#signupId').val();
			let userPassword = $('#signupPassword').val();
			let userName = $('#signupName').val();
			let userResident = $('#signupResident').val();
			let userEmail = $('#signupEmail').val();
			let userPhone = $('#signupPhone').val();
			
			console.log(userId);
			
			let send = {
				signupId : userId,
				signupPassword : userPassword,
				signupName : userName,
				signupResident : userResident,
				signupEmail : userEmail,
				signupPhone : userPhone
			}
			
			let response = ajaxRequest('post', 'userWrite', send)
			
			window.location.reload();
			}
		}
		
		/******************** 회원 탈퇴 ********************/
		if ($(e.target).hasClass('userDeleteBtn')) {
			var myWindow = window.open('userDeletePopUp', '회원탈퇴', "width=500,height=500,scrollbars=yes");
			
		}
		
		/******************** 회원 수정 ********************/
		if ($(e.target).hasClass('userUpdateBtn')) {
			if (confirm('수정 하시겠습니까?')) {
				
				let userPassword = $('#inputUserPassword').val();
				let userEmail = $('#inputUserEmail').val();
				let userPhone = $('#inputUserPhone').val();
				
				let send = {
					userPassword : userPassword,
					userEmail : userEmail,
					userPhone : userPhone
				}
				
				let response = ajaxRequest('put', 'user/update', send);
				
			}
		} 
	});
}

/*
이벤트 발생시 처리 메서드
*/
function navigate() {

	if (path == '/login') {
		let sendJsonObject = {
			userId: document.getElementById('loginId').value,
			userPassword: document.getElementById('loginPassword').value
		}
		let responseJsonObject = ajaxRequest('POST', 'user/login', sendJsonObject);

		if (responseJsonObject.status == 1000) {
			var currentHash = window.location.hash;
			
			if (currentHash === '#/login') {
			    currentHash = '';
			}
			
			var newUrl = window.location.href.split('#')[0] + currentHash;

			window.history.replaceState({}, document.title, newUrl);
			window.location.reload();
			
		}

		if (responseJsonObject.status == 1001) {
			let span = $('#loginError').text(responseJsonObject.message).css('color', 'red');
			
			var currentHash = window.location.hash;
			
			if (currentHash === '#/login') {
			    currentHash = '';
			}
			
			var newUrl = window.location.href.split('#')[0] + currentHash;

			window.history.replaceState({}, document.title, newUrl);
		}
		 
		if (responseJsonObject.status == 1002) {
			let span = $('#loginError').text(responseJsonObject.message).css('color', 'red');
			
			var currentHash = window.location.hash;
			
			if (currentHash === '#/login') {
			    currentHash = '';
			}
			
			var newUrl = window.location.href.split('#')[0] + currentHash;

			window.history.replaceState({}, document.title, newUrl);
		}
		
	}

}

init();