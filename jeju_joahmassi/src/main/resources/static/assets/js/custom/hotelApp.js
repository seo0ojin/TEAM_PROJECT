import { ajaxRequest } from './request.js';
import { createInitializer } from "./initializer.js";
import { hotelList_form } from "./template-hotelList.js";

let hash = window.location.hash
let path = hash.substring(1);
let html = '';
/*
초기실행메쏘드
*/
const initialize = createInitializer();
initialize.addCustomFunctionHandlebars();

jQuery.validator.addMethod("phone", function(phone_number, element) {
	phone_number = phone_number.replace(/\s+/g, "");
	return this.optional(element) || phone_number.length > 9 &&
		phone_number.match(/010-\d{4}-\d{4}$/);
}, "핸드폰 번호 형식으로 입력해 주세요");


$.validator.addMethod("creditCard", function(credit_card_number, element) {
	credit_card_number = credit_card_number.replace(/\s+/g, "");
	return this.optional(element) || credit_card_number.length > 16 &&
		credit_card_number.match(/\d{4}-\d{4}-\d{4}-\d{4}$/);
}, "카드 번호 형식으로 입력해주세요");


$.validator.addMethod("month", function(credit_card_month, element) {
    credit_card_month = credit_card_month.replace(/\s+/g, "");
    return this.optional(element) || /^\d{2}$/.test(credit_card_month);
}, "월을 입력해 주세요");


function init() {
	registEvent();
	navigate();


	const bookingForm = $('.hotelBooking1');
	initialize.validatorHotelBookingFormSetDefault();
	let validator = bookingForm.validate();
	initialize.setValidator(validator);

	const payForm = $('.hotelPay');
	initialize.validatorHotelPaySetDefault();
	let validator1 = payForm.validate();
	initialize.setValidator(validator1);



	$('.hotelSearchKeyword').on('keydown', function(e) {
		if (e.key === 'Enter') {
			e.preventDefault();
			search();
		}
	});
}

// 검색 함수
function search() {
	hash = window.location.hash;
	path = hash.substring(1);

	// 기존 검색 버튼 클릭 이벤트와 동일한 동작 수행
	if (path == '/hotelList/page/1') {
		navigate();
	} else {
		window.location.hash = '/hotelList/page/1';
	}
}

// ...

$(document).on('click', '#hotelSearch', function(e) {
	search();
});


/*
이벤트등록
*/

// 정렬 함수
function registEvent() {
	/****************************날짜 계산하기*****************************/
	/*
	$(window).on('load', function(e) {
		alert('load  event:' + e);
	});
	*/
	$(window).on('hashchange', function(e) {
		//alert('hashchange event:' + e);
		hash = window.location.hash;
		path = hash.substring(1);
		navigate();
	});

	$(document).on('click', function(e) {
		hash = window.location.hash;
		path = hash.substring(1);
		if (e.target.id == 'HotelFavorite') {
			$('#OrderInt').removeClass();
			$('#OrderInt').addClass('1');
			if (path == '/hotelList/page/1') {
				navigate();
			} else {
				window.location.hash = '/hotelList/page/1'
			}
		}
		if (e.target.id == 'HotelTopReview') {
			$('#OrderInt').removeClass();
			$('#OrderInt').addClass('2');
			if (path == '/hotelList/page/1') {
				navigate();
			} else {
				window.location.hash = '/hotelList/page/1'
			}
		}
		if (e.target.id == 'HotelTopPrice') {
			$('#OrderInt').removeClass();
			$('#OrderInt').addClass("3");
			if (path == '/hotelList/page/1') {
				navigate();
			} else {
				window.location.hash = '/hotelList/page/1'
			}
		}
		if (e.target.id == 'HotelRowPrice') {
			$('#OrderInt').removeClass();
			$('#OrderInt').addClass("4");
			if (path == '/hotelList/page/1') {
				navigate();
			} else {
				window.location.hash = '/hotelList/page/1'
			}
		}
		if (e.target.id == 'HotelTopStar') {
			$('#OrderInt').removeClass();
			$('#OrderInt').addClass("5");
			if (path == '/hotelList/page/1') {
				navigate();
			} else {
				window.location.hash = '/hotelList/page/1'
			}
		}

		// 카테고리 체크
		var checkboxes = document.querySelectorAll('input[type="checkbox"].hotelCategory');

		for (let i = 0; i < checkboxes.length + 1; i++) {
			if (e.target.id == 'HotelCategory' + i) {
				let categoryNo = $('#CategoryOrderInt').attr('class');

				if (categoryNo != i) {
					$('#CategoryOrderInt').removeClass();
					$('#CategoryOrderInt').addClass(i + "");
				} else {
					$('#CategoryOrderInt').removeClass();
				}

				if (path == '/hotelList/page/1') {
					navigate();
				} else {
					window.location.hash = '/hotelList/page/1'
				}
			}
		}

		// 검색
		if (e.target.id == 'hotelSearch') {
			if (path == '/hotelList/page/1') {
				navigate();
			} else {
				window.location.hash = '/hotelList/page/1'
			}
		}

		// 리뷰 작성시, 별점 평가
		var value = $(e.target).attr('value');
		var numericValue = parseInt(value);
		if ($(e.target).hasClass('star')) {
			for (let i = 1; i < numericValue + 1; i++) {
				var star = $('#hotelStar' + i);
				if (i <= numericValue) {
					star.removeClass('text-muted');
				}
			}
			for (let j = numericValue + 1; j < 6; j++) {
				var star2 = $('#hotelStar' + j);
				star2.addClass('text-muted');
			}

		}


		// 리뷰 쓰기
		if ($(e.target).hasClass('hotelReviewWrite')) {
			let hrContent = $('.hotelReviewWriteContent').val();
			let hrStar = 5;
			for (let i = 1; i < 6; i++) {
				var star = $('#hotelStar' + i);
				if ($(star).hasClass('text-muted')) {
					hrStar = hrStar - 1
				}
			}
			let hotelNo = $(e.target).attr('hotelNo');
			let userNo = $(e.target).attr('userNo');
			let sendData = {
				hrContent: hrContent,
				hrStar: hrStar,
				hotelNo: hotelNo,
				userNo: userNo
			}
			if (hrStar > 0) {
				ajaxRequest('POST', 'hotelReview/insert', sendData);
				window.location.reload();
			} else {
				confirm('별점을 선택해주세요.');
			}
		}


		/******************** 리뷰 수정 ********************/
		function hotelReviewUpdateFormHtml(responseJsonObject = {}) {
			let htmlTemplate =
				`
            	<textarea class="form-control hrReview{{hrNo}}" rows="6" cols="77" name="text" placeholder="Comment" aria-label="Hi there, I would like to ..." required="" data-msg="Please enter a reason." data-error-class="u-has-error" data-success-class="u-has-success" style="resize: none;">{{hrContent}}</textarea>
			`;

			let bindTemplate = Handlebars.compile(htmlTemplate);
			let resultTemplate = bindTemplate(responseJsonObject);
			return resultTemplate;
		}

		function hotelReviewUpdateFormHtml2(responseJsonObject = {}) {
			let htmlTemplate =
				`
				<style>
			@font-face {
			    font-family: 'SCDream5';
			    src: url("assets/fonts/SCDream5.otf") format("truetype");
			    font-weight: normal;
			    font-style: normal;
			}
			
			#hotelReviewContentFont {
				font-family: 'SCDream5';
			}
			</style>
				
            	<p class="text-lh-1dot6 mb-0 pr-lg-5 hrReview{{hrNo}}" id="hotelReviewContentFont">{{hrContent}}</p>
			`;

			let bindTemplate = Handlebars.compile(htmlTemplate);
			let resultTemplate = bindTemplate(responseJsonObject);
			return resultTemplate;
		}

		let reviewNo = $(e.target).attr('class');
		if ($(e.target).is('#hotelReview-update-button' + reviewNo)) {
			if ($(e.target).text() == '수정') {
				let send = {
					hrNo: reviewNo
				}
				let response = ajaxRequest('POST', 'hotelReview/updateForm', send);
				let html = hotelReviewUpdateFormHtml(response);
				$('.hrReview' + reviewNo).replaceWith(html);
				$('#hotelReview-update-button' + reviewNo).text('등록');
			} else {
				let hrContent = $('.hrReview' + reviewNo).val();
				let send = {
					hrNo: reviewNo,
					hrContent: hrContent
				}
				let response = ajaxRequest('POST', 'hotelReview/update', send);
				let html = hotelReviewUpdateFormHtml2(response);
				$('.hrReview' + reviewNo).replaceWith(html);
				$('#hotelReview-update-button' + reviewNo).text('수정');
			}
		}

		/******************** 리뷰 삭제 ********************/
		reviewNo = $(e.target).attr('class');

		if ($(e.target).is('#hotelReview-delete-button' + reviewNo)) {
			if (confirm('정말 삭제하시겠습니까?')) {
				let send = {
					hrNo: reviewNo
				}

				ajaxRequest('delete', 'hotelReview/delete', send)
				window.location.reload();
			}

		}


		/*****************************은행 설정 드랍박스*******************************/
		if ($(e.target).hasClass('hotelBank')) {
			let time = $(e.target).text();
			$('#hotelPayBankSelectBtn').text(time);
		}




		/*********************Detail 예약 버튼 시작 *****************************/
		if ($(e.target).hasClass('hotelBookingNow')) {

			let bookingCheckin = $('.hotelBookingCheckin').val();
			//let bookingCheckout= $('.hotelBookingCheckout').val();
			let people = $('#hotelSelectedGuestCount').text();
			let hotelNo = $('.hotelWishBtn').attr('dataNo');
			let userNo = $('.hotelWishBtn').attr('userNo');
			let bookingTotalPrice = $('.hotelPriceResult').text();

			if (userNo !== undefined) {
				if (!(people === '인원을 선택하세요' || bookingCheckin == '')) {
					
					let send = {
						bookingDate : bookingCheckin,
						people : people,
						hotelNo : hotelNo,
						hpPrice : bookingTotalPrice
					}
					
					let response = ajaxRequest('post', 'hotelBooking/duplicate', send)
					
					if (response.status == 1000) {
						window.location.href =
							"hotelBooking1?bookingDate=" + bookingCheckin + "&people=" + people + "&hotelNo=" + hotelNo + "&bookingTotalPrice=" + bookingTotalPrice;
					}
					
					if (response.status == 1001) {
						alert('예약 불가한 날짜입니다.');
					}
					
				} else {
					alert('예약 날짜 또는 인원을 선택해 주세요');
				}
			} else {
				alert('로그인이 필요한 서비스입니다');
			}
		}

		/****************************쿠폰 적용****************************/
		
		if($(e.target).attr('id') === 'CouponCodeExample2'){
			let couponName = $('#CouponCodeExample1').val();
			let totalPrice = $('.hotelTotalPrice').text();
			let send = {
				couponName : couponName,
				totalPrice : totalPrice
			}
			let response = ajaxRequest('post','hotelBooking/findCoupon' ,send);
			if(response.couponStatus==1000){
				$('.discountPrice').text('-'+response.couponDiscount);
				$('.hotelTotalPrice').text(response.totalPrice);
				$(e.target).attr('disabled', true);
			}
			if(response.couponStatus==1001){
				alert('존재하지 않는 쿠폰입니다.');
			}
		}
		
		
		/***************************첫번째 페이지 예약하기 버튼****************************/
		const bookingForm = $('.hotelBooking1');
		if ($(e.target).hasClass('btn-wide-hotelBooking')) {
			if (bookingForm.valid()) {
				let totalPrice = $('.hotelTotalPrice').text();
				let inputNameHotelBooking = $('#inputNameHotelBooking').val();
				let inputPhoneHotelBooking = $('#inputPhoneHotelBooking').val();
				let inputHotelBookingCheckin = $('#inputHotelBookingCheckin').val();
				let inputHotelBookingCheckout = $('#inputHotelBookingCheckout').val();
				let inputHotelBookingPeople = $('#inputHotelBookingPeople').val();
				let hotelNo = $('#hotelNo').val();
				let couponName = $('#CouponCodeExample1').val();

				window.location.href =
					"hotelBooking2?totalPrice=" + totalPrice + "&inputNameHotelBooking=" + inputNameHotelBooking + "&inputPhoneHotelBooking=" + inputPhoneHotelBooking
					+ "&inputHotelBookingCheckin=" + inputHotelBookingCheckin + "&inputHotelBookingCheckout=" + inputHotelBookingCheckout +
					"&inputHotelBookingPeople=" + inputHotelBookingPeople +"&couponName="+couponName +"&hotelNo=" + hotelNo;
			}
		} 
		
		
		/***************************두번째 페이지 결제하기 버튼****************************/
		const payForm = $('.hotelPay');
		if ($(e.target).hasClass('payBtn')) {
			if (payForm.valid()) {
				let totalPrice = $('#totalPrice').text();
				let inputNameHotelBooking = $('#inputNameHotelBooking').text();
				let inputPhoneHotelBooking = $('#inputPhoneHotelBooking').text();
				let inputHotelBookingDate = $('#inputHotelBookingDate').text();
				let inputHotelBookingPeople = $('#inputHotelBookingPeople').text();
				let hotelNo = $('#hotelNo').val();
				let couponName = $('#couponName').text();

				window.location.href =
					"hotelBooking3?totalPrice=" + totalPrice + "&inputNameHotelBooking=" + inputNameHotelBooking + "&inputPhoneHotelBooking=" + inputPhoneHotelBooking
					+ "&inputHotelBookingDate=" + inputHotelBookingDate +
					"&inputHotelBookingPeople=" + inputHotelBookingPeople + "&couponName="+couponName +"&hotelNo=" + hotelNo;
			}
		}
		
		/*************************** qna 작성하기 버튼 클릭 ****************************/
		if ($(e.target).hasClass('qnaBtn')) {
			let hotelNo = $('.hotelWishBtn').attr('dataNo');
			
			// 새 창 열기
			var myWindow = window.open('qnaPopup?hotelNo=' + hotelNo + '&qnaNo=0', '1:1 문의', "width=550,height=1000,scrollbars=yes");
			
			// 새 창이 로드되었을 때 이벤트 처리
			myWindow.onload = function() {
			  // qnaTitle 클래스를 가진 태그 선택
			  var qnaTitleElement = myWindow.document.querySelector(".qnaTitle");
			  var qnaContentElement = myWindow.document.querySelector(".qnaContent");
			
			  qnaTitleElement.removeAttribute("disabled"); // disabled 속성 삭제
			  qnaContentElement.removeAttribute("disabled");
			};
		}
		/*************************** 작성 문의 보기 ****************************/
		function hotelQnaAnswerForm(responseJsonObject = {}) {
			let htmlTemplate =
				`<th>답변</th>
				<td class="qa-subject-area">
					<textarea name="question" class="answerContent" rows="15" cols="58" placeholder="내용 입력" style="resize: none; background-color: transparent;">{{qnaAnswer}}</textarea>
				</td>`;

			let bindTemplate = Handlebars.compile(htmlTemplate);
			let resultTemplate = bindTemplate(responseJsonObject);
			return resultTemplate;
		}
		
		if ($(e.target).hasClass('hotelQnaView')) {
			let hotelNo = $('.hotelWishBtn').attr('dataNo');
			let qnaNo = $(e.target).attr('qnaNo');
			let qnaUserNo = $(e.target).attr('userNo');
			let loginUserNo = $('.hotelWishBtn').attr('userNo');
			
			e.preventDefault();
			
			let send = {qnaNo : qnaNo};
			let response = ajaxRequest('POST','hotelQnA/secretCheck',send);
			
			let html = hotelQnaAnswerForm(response);
			if (response.qnaSecretCheck == 1) {
				// 비밀글 일때
				if(loginUserNo == qnaUserNo){
					var myWindow = window.open('qnaPopup?hotelNo=' + hotelNo + '&qnaNo=' + qnaNo, '1:1 문의', "width=550,height=1000,scrollbars=yes");
					myWindow.onload = function() {
						var secretChk = myWindow.document.getElementById("secretChk");
						secretChk.checked = true; // 체크박스를 선택(체크) 상태로 만듦
						secretChk.disabled = true; // 체크박스를 비활성화시킴
						// 답변 완료
						if(response.qnaStatus==1){
							var answerContent = myWindow.document.querySelector('.answerContentHtml');
							$(answerContent).html(html);
							var answerContent2 = myWindow.document.querySelector('.answerContent');
							answerContent2.disabled = true;
						}
					}
				}else{
					alert('비밀글은 작성자만 볼 수 있습니다.');
				}
			}else{
				// 비밀글이 아닐때
				var myWindow = window.open('qnaPopup?hotelNo=' + hotelNo + '&qnaNo=' + qnaNo, '1:1 문의', "width=550,height=1000,scrollbars=yes");
				myWindow.onload = function() {
					var secretChk = myWindow.document.getElementById("secretChk");
					secretChk.disabled = true; // 체크박스를 비활성화시킴
					// 답변 완료
					if(response.qnaStatus==1){
						var answerContent = myWindow.document.querySelector('.answerContentHtml');
						$(answerContent).html(html);
						var answerContent2 = myWindow.document.querySelector('.answerContent');
						answerContent2.disabled = true;
					}
				}
			}
			
		}
		
		/*************************** 예약 취소 버튼 클릭 ****************************/
		if ($(e.target).hasClass('hotelBookingDeleteBtn')) {
			let bookingNo = $(e.target).closest('tr').find('td:hidden').attr('class');
			let realBookingNo = bookingNo.substring(4);
			
			var myWindow = window.open('hotelBookingDeletePopUp?hbNo=' + realBookingNo, '숙소 예약 취소', "width=500,height=500,scrollbars=yes");
			
		}
		
		
		
	});
	
	
	
	
	
/****************************onclick 끝********************************/
	function hotelPriceUpdateFormHtml(responseJsonObject = {}) {
		let htmlTemplate =
			`
        	<span class="hotelPriceResult font-size-24 text-gray-6 font-weight-bold ml-1">{{totalPrice}}</span>
		`;

		let bindTemplate = Handlebars.compile(htmlTemplate);
		let resultTemplate = bindTemplate(responseJsonObject);
		return resultTemplate;
	}
	
	
	function testHtml(responseJsonObject = {}) {
		let htmlTemplate =
			`
        	<a class="js-minus btn btn-icon btn-medium btn-outline-secondary rounded-circle hotelBookingPersonnel" href="javascript:;">
                <small class="fas fa-minus btn-icon__inner hotelBookingPersonnel"></small>
            </a>
            <input class="hotelPersonelResult js-result form-control h-auto border-0 rounded p-0 max-width-6 text-center" type="text" value="1">
            <a class="js-plus btn btn-icon btn-medium btn-outline-secondary rounded-circle hotelBookingPersonnel" href="javascript:;">
                <small class="fas fa-plus btn-icon__inner hotelBookingPersonnel"></small>
            </a>
		`;

		let bindTemplate = Handlebars.compile(htmlTemplate);
		let resultTemplate = bindTemplate(responseJsonObject);
		return resultTemplate;
	}

	// 날짜 했을때 계산
	$('.hotelBookingCheckin').on('input', function() {
		// 1박 기준 호텔 가격 (고정값)
		let hotelPrice = parseInt($('.hotelPriceHidden').text());

		let additionalPrice = BookingPeopleCal();

		// 날짜 계산
		let dateCal = BookingDateCal();

		let totalPrice = (hotelPrice + additionalPrice) * dateCal;

		let send = {
			totalPrice: totalPrice
		}
		
		if (totalPrice > 0) {
			let html = hotelPriceUpdateFormHtml(send);
			$('.hotelPriceResult').replaceWith(html);
		}
	});

	// 카테고리 체크 하나만 되도록 	
	$(document).on('click', '.custom-control-input', function() {
		$('.custom-control-input').not(this).prop('checked', false);
	});

	$('.js-minus').addClass('disabled');
	$('.js-plus, .js-minus').on('click', function(e) {
		e.preventDefault();
		let minPeople = 1;
		let maxPeople = 4;

		let selectedPeople = parseInt($('.hotelPersonelResult').val());
		let p = $('.hotelSelectedGuestCount').val();
		
		// 플러스 버튼 또는 마이너스 버튼 클릭 시
		if ($(this).hasClass('js-plus')) {
			// 플러스 버튼 클릭 시 최대 인원 초과 확인
			if (selectedPeople < maxPeople) {
				selectedPeople++;
			}

			// 최대값 이상이면 최대값으로 설정하고 버튼 비활성화
			if (selectedPeople >= maxPeople) {
				selectedPeople = maxPeople;
				$(this).prop('disabled', true);
				$(this).addClass('disabled');
			} else {
				$('.js-minus').prop('disabled', false); // 플러스 버튼 클릭 시 마이너스 버튼 활성화
				$('.js-minus').removeClass('disabled');
			}
			
		} else if ($(this).hasClass('js-minus')) {
			// 마이너스 버튼 클릭 시 최소 인원 미만 확인
			if (selectedPeople > minPeople) {
				selectedPeople--;
				$('.js-plus').prop('disabled', false); // 마이너스 버튼 클릭 시 플러스 버튼 활성화
				$('.js-plus').removeClass('disabled');
			}
		}
		
		if(selectedPeople==minPeople){
			$('.js-minus').addClass('disabled');
		}
		
		// 최소값 및 최대값 적용
		if (selectedPeople < minPeople) {
			selectedPeople = minPeople;
		}
		
		// 값 업데이트
		$('.hotelPersonelResult').val(selectedPeople);
		$('#hotelSelectedGuestCount').text(selectedPeople + '명');
		
		// 1박 기준 호텔 가격 (고정값)
		let hotelPrice = parseInt($('.hotelPriceHidden').text());

		let additionalPrice = BookingPeopleCal();

		// 날짜 계산
		let dateCal = BookingDateCal();

		let totalPrice = (hotelPrice + additionalPrice) * dateCal;

		let bookingPrice = $('.hotelTotalPrice').val(totalPrice);
		
		let send = {
			totalPrice: totalPrice
		}
		let html = hotelPriceUpdateFormHtml(send);
		$('.hotelPriceResult').replaceWith(html);
		
		// 나머지 로직 추가…

		// 예약 총 가격 업데이트 로직
		//updateTotalPrice();
	});


	
	
	
	
}

function BookingPeopleCal() {
	let minPeople = 1
	let maxPeople = 4

	// 선택된 인원 가져오기
	let selectedPeople = parseInt($('.hotelPersonelResult').val());

	/*if ($('.hotelPersonelResult').val() < maxPeople) {
		$('#hotelSelectedGuestCount').text($('.hotelPersonelResult').val() + '명');
	} else {
		$('#hotelSelectedGuestCount').text(maxPeople + '명')
		$('.hotelPersonelResult').val(maxPeople)
		$('#hotelSelectedGuestCount').val(maxPeople)
	}
	if (minPeople <= $('.hotelPersonelResult').val()) {
		$('#hotelSelectedGuestCount').text($('.hotelPersonelResult').val() + '명');
	} else {
		$('#hotelSelectedGuestCount').text(minPeople + '명')
		$('.hotelPersonelResult').val(minPeople)
	}*/

	// 인원이 3명 이상인 경우에만 추가 비용 계산
	let additionalPrice = (selectedPeople > 2) ? ((selectedPeople - 2) * 30000) : 0;

	return additionalPrice;
}

function BookingDateCal() {
	// $('.hotelBookingCheckin')의 값을 가져오기
	let dateRangeString = $('.hotelBookingCheckin').val();
	let daysDifference = 0;
	// 값이 존재하는 경우에만 registEvent 함수 실행
	if (dateRangeString) {
		// '-'를 기준으로 문자열 분할
		let dateArray = dateRangeString.split(' - ');

		// dateArray[0]에는 시작 날짜, dateArray[1]에는 종료 날짜가 들어있음
		let startDateString = dateArray[0];
		let endDateString = dateArray[1];


		let startDate = new Date(startDateString);
		let endDate = new Date(endDateString);

		// 두 날짜 간의 차이 계산 (밀리초로 반환)
		let timeDifference = endDate - startDate;

		// 차이를 일(day) 단위로 변환
		daysDifference = timeDifference / (1000 * 60 * 60 * 24);

	} else {
	}
	return daysDifference;
}

function hotelQnAHtml(responseJsonObject = {}){
	let htmlTemplate = 
	`
	
	{{#each this}}
	<tr>
											<td class="center">
												{{qnaNo}}
											</td>
											<td class="center">
												{{#ifCond qnaStatus '==' 0}}
												<strong>
												답변대기
												</strong>
												{{else}}
												<strong>
												답변완료
												</strong>
												{{/ifCond}}
											</td>
											<!--<td>사이즈</td>-->
											<td class="center"> {{qnaName}}
											</td>
											<td class="qa_contents center">
												<a href="" class="hotelQnaView" qnaNo="{{qnaNo}}" th:userNo = "{{userNo}}">
													{{qnaTitle}}
													&nbsp;<span class="icon_key"></span><!--비밀글 아이콘 영역입니다.//-->
												</a>
											</td>
											{{#ifCond qnaSecretCheck '==' 1}}
											<td class="center"><strong>비밀글</strong></td>
											{{else}}
											<td class="center"><strong></strong></td>
											{{/ifCond}}
											<td class="center"><strong >{{qnaDate}}</strong></td>
										</tr>
										{{/each}}`
		let bindTemplate = Handlebars.compile(htmlTemplate);
		let resultTemplate = bindTemplate(responseJsonObject);
		return resultTemplate;
}

function hotelQnAPagePrev(responseJsonObject = {}){
	let htmlTemplate=`
		{{#ifCond preSize '>' 0}}
		<a class="fa fa-angle-left paging-btn btn hotelQnAprev" href="#/hotelQnAList/page/{{minus page 1}}"></a>
		{{else}}
		<a class="hotelQnAprev"></a>
		{{/ifCond}}
	`;
	
	let bindTemplate = Handlebars.compile(htmlTemplate);
	let resultTemplate = bindTemplate(responseJsonObject);
	return resultTemplate;
}

function hotelQnAPageNext(responseJsonObject = {}){
	let htmlTemplate=`
		{{#ifCond nextSize '>' 0}}
		<a class="fa fa-angle-right paging-btn btn hotelQnAnext" href="#/hotelQnAList/page/{{plus page 1}}"></a>
		{{else}}
		<a class="hotelQnAnext"></a>
		{{/ifCond}}
	`;
	
	let bindTemplate = Handlebars.compile(htmlTemplate);
	let resultTemplate = bindTemplate(responseJsonObject);
	return resultTemplate;
}

/*
	이벤트발생시 처리메쏘드
*/


// 페이징 함수
function navigate() {
	let page = 0;
	let order = $('#OrderInt').attr('class');
	let categoryNo = $('#CategoryOrderInt').attr('class');
	let searchKeyword = $('.hotelSearchKeyword').val();

	if (categoryNo == "") {
		categoryNo = 0;
	}

	if (path.includes('page')) {
		page = path.substring(path.lastIndexOf("page") + 5);
	}

	/*if (path == '/hotelList/page/' + page) {
		page = path.substring(path.lastIndexOf("page") + 5);
	}*/

	if (path == '/hotelList/page/' + page) {

		let categoryNoInt = parseInt(categoryNo);

		let sendJsonObject = {
			page: page,
			order: order,
			categoryNo: categoryNoInt,
			searchKeyword: searchKeyword
		}

		let responseObject = ajaxRequest('POST', 'hotel/list', sendJsonObject);

		html = hotelList_form(responseObject);

		$('#content2').html(html);
		$('#PageInt').addClass(page);
		$('#OrderInt').addClass(order);
		$('#CategoryOrderInt').removeClass();
		$('#CategoryOrderInt').addClass(categoryNo);

		// 페이지 바뀌고 스크롤 맨 위로
		window.scrollTo(0, 0);
	}
	
	if (path == '/hotelQnAList/page/' + page) {
		let hotelNo = $('.hotelWishBtn').attr('dataNo');
		let send = {
					hotelNo : hotelNo,
					page : page
					}
		let response = ajaxRequest('POST', 'hotelQnA/qnaList', send);
		let html = hotelQnAHtml(response);
		$('.hotelQnaBody').html(html);
		let preSizeValue = response[0].preSize;
		let send2 = {
			page : parseInt(page),
			preSize : preSizeValue
		}
		let html2 = hotelQnAPagePrev(send2);
		$('.hotelQnAprev').replaceWith(html2);
		
		let nextSizeValue = response[0].nextSize;
		let send3 = {
			page : parseInt(page),
			nextSize : nextSizeValue
		}
		let html3 = hotelQnAPageNext(send3)
		$('.hotelQnAnext').replaceWith(html3);
	}
}


init();