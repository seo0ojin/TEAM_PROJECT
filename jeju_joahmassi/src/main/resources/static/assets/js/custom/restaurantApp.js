import {ajaxRequest} from './request.js';
import {createInitializer} from "./initializer.js";
import {restaurantList_form} from "./template-restaurantList.js";

let hash = window.location.hash
let path = hash.substring(1);
let html = '';

/*
초기실행메쏘드
*/
const initialize=createInitializer();
initialize.addCustomFunctionHandlebars();

jQuery.validator.addMethod("phone", function(phone_number, element) {
    phone_number = phone_number.replace(/\s+/g, "");
    return this.optional(element) || phone_number.length > 9 && 
    phone_number.match(/010-\d{4}-\d{4}$/);
}, "핸드폰 번호 형식으로 써주세요");

function init() {
	registEvent();
	navigate()
	
	// 식당 예약 페이지 1 유효성
	let form = $('.restaurantBookingForm1');
	initialize.validatorRetaurantBooking1SetDefault();
	let validator = form.validate();
	initialize.setValidator(validator);
	
}
/*
이벤트등록
*/
function registEvent() {
	
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
		
		// 식당 예약순
		if(e.target.id=='RestaurantBooking'){
			$('#OrderInt').removeClass();
			$('#OrderInt').addClass('1');
			if(path=='/restaurantList/page/1'){
				navigate();
			}else{
				window.location.hash='/restaurantList/page/1'
			}
		}
		// 식당 별점순
		if(e.target.id=='RestaurantTopStars'){
			$('#OrderInt').removeClass();
			$('#OrderInt').addClass('2');
			if(path=='/restaurantList/page/1'){
				navigate();
			}else{
				window.location.hash='/restaurantList/page/1'
			}
		}
		// 식당 리뷰많은순
		if(e.target.id=='RestaurantTopReview'){
			$('#OrderInt').removeClass();
			$('#OrderInt').addClass("3");
			if(path=='/restaurantList/page/1'){
				navigate();
			}else{
				window.location.hash='/restaurantList/page/1'
			}
		}
		
		// 카테고리 체크
		var checkboxes = document.querySelectorAll('input[type="checkbox"].restaurantCategory');
		for(let i=0; i < checkboxes.length+1; i++) {
			if(e.target.id=='RestaurantCategory'+ i){
				let categoryNo = $('#CategoryOrderInt').attr('class');
				
				if(categoryNo != i){
					$('#CategoryOrderInt').removeClass();
					$('#CategoryOrderInt').addClass(i+"");
				}else{
					$('#CategoryOrderInt').removeClass();
				}
				
				if(path=='/restaurantList/page/1'){
					navigate();
				}else{
					window.location.hash='/restaurantList/page/1'
				}
			}
		}
		
		// 검색
		if(e.target.id=='restaurantSearch'){
			if(path=='/restaurantList/page/1'){
				navigate();
			}else{
				window.location.hash='/restaurantList/page/1'
			}
		}
		
		// 별점 평가
		var value = $(e.target).attr('value');
		var numericValue = parseInt(value);
		if ($(e.target).hasClass('star')) {
			for (let i = 1; i < numericValue + 1; i++) {
				var star = $('#restaurantStar' + i);
	
				if (i <= numericValue) {
	       		  	star.removeClass('text-muted');
	    		} 
			}
			for(let j = numericValue + 1; j < 6; j++){
				var star2 = $('#restaurantStar' + j);
				star2.addClass('text-muted');
			}
		}
		
		// 리뷰 쓰기
		if($(e.target).hasClass('restaurantReviewWrite')){
			let rrContent = $('.restaurantReviewWriteContent').val();
			let rrStar = 5;
			for(let i=1; i < 6; i++){
				var star = $('#restaurantStar' + i);
				if($(star).hasClass('text-muted')){
					rrStar = rrStar - 1
				}
			}
			let restaurantNo = $(e.target).attr('restaurantNo');
			let userNo = $(e.target).attr('userNo');
			let sendData = {
				rrContent : rrContent,
				rrStar: rrStar,
				restaurantNo: restaurantNo,
				userNo : userNo
			}
			if(rrContent!=""){
				if(rrStar > 0){
					ajaxRequest('POST','restaurantReview/insert',sendData);
					window.location.reload();
				}else{
					alert('별점을 선택해주세요.');
				}
			}else{
				alert('리뷰 내용을 입력해주세요.');
			}
		}
		
		/******************** 리뷰 수정 ********************/
		function restaurantReviewUpdateFormHtml(responseJsonObject = {}) {
			let htmlTemplate =
			`
            	<textarea class="form-control rrReview{{rrNo}}" rows="6" cols="77" name="text" placeholder="Comment" aria-label="Hi there, I would like to ..." required="" data-msg="Please enter a reason." data-error-class="u-has-error" data-success-class="u-has-success" style="resize: none; word-wrap: break-word; overflow-wrap: break-word; word-break: break-all;" >{{rrContent}}</textarea>
			`;
				
			let bindTemplate = Handlebars.compile(htmlTemplate);
			let resultTemplate = bindTemplate(responseJsonObject);
			return resultTemplate;
		}
		
		function restaurantReviewUpdateFormHtml2(responseJsonObject = {}) {
			let htmlTemplate =
			`
				<style>
			@font-face {
			    font-family: 'SCDream5';
			    src: url("assets/fonts/SCDream5.otf") format("truetype");
			    font-weight: normal;
			    font-style: normal;
			}
			
			#retaurantReviewContentFont {
				font-family: 'SCDream5';
			}
			</style>
			
            	<p class="text-lh-1dot6 mb-0 pr-lg-5 rrReview{{rrNo}}" id="retaurantReviewContentFont" style="word-wrap: break-word; overflow-wrap: break-word; word-break: break-all;">{{rrContent}}</p>
			`;
				
			let bindTemplate = Handlebars.compile(htmlTemplate);
			let resultTemplate = bindTemplate(responseJsonObject);
			return resultTemplate;
		}
		
		let reviewNo = $(e.target).attr('class');
	 	if ($(e.target).is('#restaurantReview-Update-button'+reviewNo)) {
			 if($(e.target).text()=='수정'){
				 let send = {
				 	rrNo : reviewNo
				 }
				 let response = ajaxRequest('POST', 'restaurantReview/updateForm', send);
				 let html = restaurantReviewUpdateFormHtml(response);
				 $('.rrReview' + reviewNo).replaceWith(html);
				 $('#restaurantReview-Update-button' + reviewNo).text('등록');
			 }else{
				 let rrContent = $('.rrReview'+reviewNo).val();
				 let send = {
				 	rrNo : reviewNo,
				 	rrContent : rrContent
				 }
				 let response = ajaxRequest('POST', 'restaurantReview/update', send);
				 let html = restaurantReviewUpdateFormHtml2(response);
				 $('.rrReview' + reviewNo).replaceWith(html);
				 $('#restaurantReview-Update-button' + reviewNo).text('수정');
			 }
		 }
		
		/******************** 리뷰 삭제 ********************/
		reviewNo = $(e.target).attr('class');
		if ($(e.target).is('#restaurantReview-delete-button'+reviewNo)) {
			if (confirm('정말 삭제하시겠습니까?')) {
				let send = {
					rrNo : reviewNo
				}
				ajaxRequest('delete', 'restaurantReview/delete', send)
				window.location.reload();
			}
		}
		
		/*********************Detail 예약 버튼 시작 *****************************/
		if($(e.target).hasClass('RestaurantBookingNow')){
			let bookingDate = $('.RestaurantBookingDate').val();
			let restaurantNo = $('.restaurantWishBtn').attr('dataNo');
			let people = $('#RestaurantSelectedGuestCount').text();
			let bookingTime = $('#RestaurantBookingTimeBtn').text();
			let userNo = $('.restaurantWishBtn').attr('userNo');
			
			if(userNo !== undefined){
				if (!(people === "인원을 선택하세요" || bookingTime.includes("선택") || bookingDate=="" )) {
					window.location.href=
					"restaurantBooking1?bookingDate="+bookingDate+"&people="+people+"&restaurantNo="+restaurantNo+
					"&bookingTime="+bookingTime;
				}else{
					alert('예약 시간 또는 인원을 선택해주세요.');
				}
			}else{
				alert('로그인을 해주세요')
			}
		}
			
		// 예약 시간 설정
		if($(e.target).hasClass('restaurantTime')){
			let time = $(e.target).text();
			$('#RestaurantBookingTimeBtn').text(time);
		}
		
		/****************************예약 인원 입력****************************/
		if($(e.target).hasClass('RestaurantBookingPersonnel')){
			/*let maxPeople = 10;
			let minPeople = 1;
			
			if( $('.RestaurantPersonelResult').val() < maxPeople){
				$('#RestaurantSelectedGuestCount').text($('.RestaurantPersonelResult').val()+'명');
			}else{
				$('#RestaurantSelectedGuestCount').text(maxPeople+'명')
				$('.RestaurantPersonelResult').val(maxPeople)
				$('#RestaurantSelectedGuestCount').val(maxPeople)
			}
			
			if( minPeople <= $('.RestaurantPersonelResult').val() ){
				$('#RestaurantSelectedGuestCount').text($('.RestaurantPersonelResult').val()+'명');
			}else{
				$('#RestaurantSelectedGuestCount').text(minPeople+'명')
				$('.RestaurantPersonelResult').val(minPeople)
			}*/
		}
		
		if($(e.target).hasClass('restaurantBookingNextPage')){
			if ($('.restaurantBookingForm1').valid()) {
				let restaurantNo = $('#restaurantNo').val();
				let restaurantBooking1Name = $('#restaurantBooking1Name').val();
				let restaurantBooking1Phone = $('#restaurantBooking1Phone').val();
				let restaurantBooking1Date = $('#restaurantBooking1Date').val();
				let restaurantBooking1Time = $('#restaurantBooking1Time').val();
				let restaurantBooking1Personnel = $('#restaurantBooking1Personnel').val();
				let send = {
					restaurantNo : restaurantNo,
					restaurantBooking1Name : restaurantBooking1Name,
					restaurantBooking1Phone : restaurantBooking1Phone,
					restaurantBooking1Date : restaurantBooking1Date,
					restaurantBooking1Time : restaurantBooking1Time,
					restaurantBooking1Personnel : restaurantBooking1Personnel
				}
				let response = ajaxRequest('POST','restaurantBooking/duplication',send);
				if(response.status == 1000){
					window.location.href = 
					'restaurantBooking2?restaurantNo='+restaurantNo+'&restaurantBooking1Name='+restaurantBooking1Name+
					'&restaurantBooking1Phone='+restaurantBooking1Phone+'&restaurantBooking1Date='+restaurantBooking1Date+
					'&restaurantBooking1Time='+restaurantBooking1Time+'&restaurantBooking1Personnel='+restaurantBooking1Personnel;
				}
				if(response.status == 1001){
					alert('예약이 불가능한 시간입니다.');
				}
			}
		}
		
		/*************************** 예약 취소 ****************************/
		if ($(e.target).hasClass('restaurantBookingDeleteBtn')) {
			let bookingNo = $(e.target).closest('tr').find('td:hidden').attr('class');
			let realBookingNo = bookingNo.substring(4);
			
			var myWindow = window.open('restaurantBookingDeletePopUp?rbNo=' + realBookingNo, '식당 예약 취소', "width=470,height=400,scrollbars=yes");
		}
		
	});
	
   $('.js-minus').addClass('disabled');
   $('.js-plus, .js-minus').on('click', function(e) {
      e.preventDefault();
      let minPeople = 1;
      let maxPeople = 4;

      let selectedPeople = parseInt($('.RestaurantPersonelResult').val());
      let p = $('.RestaurantSelectedGuestCount').val();
      
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
      $('.RestaurantPersonelResult').val(selectedPeople);
      $('#RestaurantSelectedGuestCount').text(selectedPeople + '명');
      
	});
	
	// 체크 하나만 되게
	$(document).on('click', '.custom-control-input', function() {
		$('.custom-control-input').not(this).prop('checked', false);
	});
	
	// 검색 엔터로 되게
	$('.restaurantSearchKeyword').on('keydown', function(e) {
        if (e.key === 'Enter') {
			e.preventDefault();
			
			if (path == '/restaurantList/page/1') {
				navigate();
			} else {
				window.location.hash = '/restaurantList/page/1';
			}
		}
    });
		
}

/*
	이벤트발생시 처리메쏘드
*/
function navigate() {
	let page = 0;
	let order = $('#OrderInt').attr('class');
	let categoryNo = $('#CategoryOrderInt').attr('class');
	let searchKeyword = $('.restaurantSearchKeyword').val();
	
	if(categoryNo == ""){
		categoryNo = 0;
	}
	if(path.includes('page')){
		page = path.substring(path.lastIndexOf("page")+5);
	}
	if (path == '/restaurantList/page/'+page) {
		let categoryNoInt = parseInt(categoryNo);
		let sendJsonObject = {
			page : page,
			order : order,
			categoryNo : categoryNoInt,
			searchKeyword : searchKeyword
		}
		let responseObject = ajaxRequest('POST','restaurant/list',sendJsonObject);
		html = restaurantList_form(responseObject);
		$('#content2').html(html);
		$('#PageInt').addClass(page);
		$('#OrderInt').addClass(order);
		$('#CategoryOrderInt').removeClass();
		$('#CategoryOrderInt').addClass(categoryNo);
		
		// 페이지 바뀌고 스크롤 맨 위로
		window.scrollTo(0, 0);
	}
}

init();
