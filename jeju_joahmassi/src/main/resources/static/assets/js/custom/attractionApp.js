import { ajaxRequest } from "./request.js";
import { createInitializer } from "./initializer.js";
import { attractionList_form } from "./template-attractionList.js";

let hash = window.location.hash
let path = hash.substring(1);
let html = '';

/*
초기 실행 메서드
*/
const initialize = createInitializer();
initialize.addCustomFunctionHandlebars();

function init() {
	registEvent();
	navigate();
}

/*
이벤트 등록
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
		if (e.target.id == 'Stars') {
			$('#OrderInt').removeClass();
			$('#OrderInt').addClass('1');
			if (path == '/attractionList/page/1') {
				navigate();
			} else {
				window.location.hash = '/attractionList/page/1'
			}
		}

		if (e.target.id == 'TopReview') {
			$('#OrderInt').removeClass();
			$('#OrderInt').addClass('2')
			if (path == '/attractionList/page/1') {
				navigate();
			} else {
				window.location.hash = '/attractionList/page/1'
			}
		}

		var checkboxes = document.querySelectorAll('input[type="checkbox"].attractionCategory')

		for (let i = 0; i < checkboxes.length + 1; i++) {
			if (e.target.id == 'attractionCategory' + i) {
				let categoryNo = $('#CategoryOrderInt').attr('class');

				if (categoryNo != i) {
					$('#CategoryOrderInt').removeClass();
					$('#CategoryOrderInt').addClass(i + "");	
				} else {
					$('#CategoryOrderInt').removeClass();
				}
				
				if (path == '/attractionList/page/1') {
					navigate();
				} else {
					window.location.hash = '/attractionList/page/1'
				}
			}
		}
		
		if (e.target.id == 'attractionSearch') {
			if (path == '/attractionList/page/1') {
				navigate();

			} else {
				window.location.hash = '/attractionList/page/1'
			}
		}
		
		/******************** 리뷰 쓰기 ********************/
		if ($(e.target).hasClass('attractionReviewWrite')) {
			let arContent = $('.attractionReviewWriteContent').val();
			let arStar = 5;
			
			for (let i = 1; i < 6; i++) {
				var star = $('#star' + i);
				
				if ($(star).hasClass('text-muted')) {
					arStar = arStar - 1;
				}
			}
			
			let attractionNo = parseInt($(e.target).attr('attractionNo'));
			let userNo = parseInt($(e.target).attr('userNo'));
			
			
			let send = {
				arContent : arContent,
				arStar : arStar,
				attractionNo : attractionNo,
				userNo : userNo
			}
			
			if (arStar > 0) {
				ajaxRequest('POST', 'attractionReview/insert', send);
				window.location.reload();
			} else {
				alert('별점을 선택해주세요.');
			}
		}
		
		/******************** 리뷰 수정 ********************/
		function reviewUpdateFormHtml(responseJsonObject = {}) {
			let htmlTemplate =
			`
            	<textarea class="form-control arReview{{arNo}}" rows="6" cols="77" name="text" placeholder="Comment" aria-label="Hi there, I would like to ..." required="" data-msg="Please enter a reason." data-error-class="u-has-error" data-success-class="u-has-success" style="resize: none;">{{arContent}}</textarea>
			`;
				
			let bindTemplate = Handlebars.compile(htmlTemplate);
			let resultTemplate = bindTemplate(responseJsonObject);
			return resultTemplate;
		}
		
		function reviewUpdateFormHtml2(responseJsonObject = {}) {
			let htmlTemplate =
			`
			<style>
			@font-face {
			    font-family: 'SCDream5';
			    src: url("assets/fonts/SCDream5.otf") format("truetype");
			    font-weight: normal;
			    font-style: normal;
			}
			
			#attractionReviewContentFont {
				font-family: 'SCDream5';
			}
			</style>
			
            	<p class="text-lh-1dot6 mb-0 pr-lg-5 arReview{{arNo}}" id="attractionReviewContentFont">{{arContent}}</p>
			`;
				
			let bindTemplate = Handlebars.compile(htmlTemplate);
			let resultTemplate = bindTemplate(responseJsonObject);
			return resultTemplate;
		}
		
		let reviewNo = $(e.target).attr('class');
	 	if ($(e.target).is('#update-button' + reviewNo)) {
			 if ($(e.target).text()=='수정') {
				 
				 let send = {
				 	arNo : reviewNo
				 }
				 
				 let response = ajaxRequest('put', 'attractionReview/updateForm', send);
				 let html = reviewUpdateFormHtml(response);
				 $('.arReview' + reviewNo).replaceWith(html);
				 $('#update-button' + reviewNo).text('등록');
			 
			 } else {
				 let arContent = $('.arReview'+reviewNo).val();
				 
				 let send = {
				 	arNo : reviewNo,
				 	arContent : arContent
				 }
				 
				 let response = ajaxRequest('put', 'attractionReview/update', send);
				 let html = reviewUpdateFormHtml2(response);
				 $('.arReview' + reviewNo).replaceWith(html);
				 $('#update-button' + reviewNo).text('수정');
			 }
		 }
		
		/******************** 리뷰 삭제 ********************/
		reviewNo = $(e.target).attr('class');
		if ($(e.target).is('#delete-button' + reviewNo)) {
			if (confirm('정말 삭제하시겠습니?')) {
				
				let send = {
					arNo : reviewNo
				}
				
				ajaxRequest('delete', 'attractionReview/delete', send)
				window.location.reload();
			}
		}
				
		
		/******************** 리뷰 별점 *******************/
		var value = $(e.target).attr('value');
		var numericValue = parseInt(value);
		
		if ($(e.target).hasClass('star')) {
			for (let i = 1; i < numericValue + 1; i++) {
				var star = $('#star' + i);
	
				if (i <= numericValue) {
	       		  	star.removeClass('text-muted');
	    		} 
			}
			
			for(let j = numericValue + 1; j < 6; j++){
				var star2 = $('#star' + j);
				star2.addClass('text-muted');
			}
			
		}
	});

	// 체크 박스 한 개 선택
	$(document).on('click', '.custom-control-input', function() {
		$('.custom-control-input').not(this).prop('checked', false);

	});
	
	// 엔터로 검색
	$('.attractionSearchKeyword').on('keydown', function(e) {
        if (e.key === 'Enter') {
			e.preventDefault();
			
			if (path == '/attractionList/page/1') {
				navigate();
			} else {
				window.location.hash = '/attractionList/page/1';
			}
		}
    }); 
    
}

/*
이벤트 발생시 처리 메서드
*/
function navigate() {
	let page = 0;
	let order = $('#OrderInt').attr('class');
	let categoryNo = $('#CategoryOrderInt').attr('class');
	let searchKeyword = $('.attractionSearchKeyword').val();
	
	if (categoryNo == "") {
		categoryNo = 0;
	}
 	if (path.includes('page')){
		page = path.substring(path.lastIndexOf('page') + 5);
	}
	
	if (path == '/attractionList/page/' + page) {
		let categoryNoInt = parseInt(categoryNo)
		let sendJsonObject = {
			page : page,
			order : order,
			categoryNo : categoryNoInt,
			searchKeyword : searchKeyword
		}
		
		let responseObject = ajaxRequest('POST', 'attraction/list', sendJsonObject);
		
		html = attractionList_form(responseObject);
		$('#content2').html(html);
		$('#PageInt').addClass(page);
		$('#OrderInt').addClass(order);
		$('#CategoryOrderInt').removeClass();
		$('#CategoryOrderInt').addClass(categoryNo);
		
		// 페이지 바뀐 후 스크롤 맨 위로
		window.scrollTo(0, 0);
	}

}


init();