import {ajaxRequest} from './request.js';
import {createInitializer} from "./initializer.js";
import {wish_restaurantList_form} from "./template-wish-restaurantList.js";
import {wish_HotelList_form} from "./template-wish-hotelList.js";
import {wish_attractionList_form} from "./template-wish-attractionList.js";

let hash = window.location.hash
let path = hash.substring(1);
let html = '';

/*
초기실행메쏘드
*/
const initialize=createInitializer();
initialize.addCustomFunctionHandlebars();

function init() {
	registEvent();
	navigate();
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
		
		var classes = e.target.classList;
		
	    if (classes.length > 0) {
			
	        var firstClass = classes[0];
	        
	        /**********************************호텔***********************************/
	         if (firstClass === 'wishHeartHotelInsert') {
				let hotelNo = e.target.getAttribute('dataNo');
	            let sendJsonObject = {
					hotelNo : hotelNo
				}
				ajaxRequest('POST','wish/insertHotel',sendJsonObject);
				$(e.target).parent().html('<span class="wishHeartHotelDelete fi fi-ss-heart font-size-20 text-danger" dataNo=""></span>');
	        	$('.wishHeartHotelDelete').attr('dataNo',hotelNo);
	        }
	        if (firstClass === 'wishHeartHotelDelete') {
				let hotelNo = e.target.getAttribute('dataNo');
	            let sendJsonObject = {
					restaurantNo : 0,
					hotelNo : hotelNo,
					attractionNo : 0
				}
				ajaxRequest('Delete','wish/deleteWish',sendJsonObject);
				$(e.target).parent().html('<span class="wishHeartHotelInsert flaticon-heart-1 font-size-20 " dataNo=""></span>');
	        	$('.wishHeartHotelInsert').attr('dataNo',hotelNo);
			}
	        
			/**********************************식당***********************************/
	        if (firstClass === 'wishHeartRestaurantInsert') {
				let restaurantNo = e.target.getAttribute('dataNo');
	            let sendJsonObject = {
					restaurantNo : restaurantNo
				}
				ajaxRequest('POST','wish/insertRestaurant',sendJsonObject);
				$(e.target).parent().html('<span class="wishHeartRestaurantDelete fi fi-ss-heart font-size-20 text-danger" dataNo=""></span>');
	        	$('.wishHeartRestaurantDelete').attr('dataNo',restaurantNo);
	        }
	        if (firstClass === 'wishHeartRestaurantDelete') {
				let restaurantNo = e.target.getAttribute('dataNo');
	            let sendJsonObject = {
					restaurantNo : restaurantNo,
					hotelNo : 0,
					attractionNo : 0
				}
				ajaxRequest('Delete','wish/deleteWish',sendJsonObject);
				$(e.target).parent().html('<span class="wishHeartRestaurantInsert flaticon-heart-1 font-size-20" dataNo=""></span>');
	        	$('.wishHeartRestaurantInsert').attr('dataNo',restaurantNo);
			}
			
			/**********************************명소***********************************/
			if (firstClass === 'wishHeartAttractionInsert') {
				let attractionNo = e.target.getAttribute('dataNo');
				console.log(attractionNo);
	            let sendJsonObject = {
					attractionNo : attractionNo
				}
				ajaxRequest('POST','wish/insertAttraction', sendJsonObject);
				$(e.target).parent().html('<span class="wishHeartAttractionDelete fi fi-ss-heart font-size-20 text-danger" dataNo=""></span>');
	        	$('.wishHeartAttractionDelete').attr('dataNo', attractionNo);
	        }
	        if (firstClass === 'wishHeartAttractionDelete') {
				let attractionNo = e.target.getAttribute('dataNo');
	            let sendJsonObject = {
					restaurantNo : 0,
					hotelNo : 0,
					attractionNo : attractionNo
				}
				ajaxRequest('Delete','wish/deleteWish', sendJsonObject);
				$(e.target).parent().html('<span class="wishHeartAttractionInsert flaticon-heart-1 font-size-20" dataNo=""></span>');
	        	$('.wishHeartAttractioInsert').attr('dataNo',attractionNo);
			}
	    }	
		
	});
	
	$(document).on('click', '.custom-control-input', function() {
		$('.custom-control-input').not(this).prop('checked', false);
	});
}

/*
	이벤트발생시 처리메쏘드
*/
function navigate() {
	let page = 0;
	let order = $('#OrderInt').attr('class');
	let categoryNo = $('#CategoryOrderInt').attr('class');
	if(categoryNo == ""){
		categoryNo = 0;
	}
	if(path.includes('page')){
		page = path.substring(path.lastIndexOf("page")+5);
	}
	// 식당
	if (path == '/wishRestaurantList/page/'+page) {
		let categoryNoInt = parseInt(categoryNo);
		let sendJsonObject = {
			page : page,
			order : order,
			categoryNo : categoryNoInt
		}
		let responseObject = ajaxRequest('POST','wish/restaurantlist',sendJsonObject);
		console.log(responseObject);
		html = wish_restaurantList_form(responseObject);
		$('#content2').html(html);
		$('#PageInt').addClass(page);
		$('#OrderInt').addClass(order);
		$('#CategoryOrderInt').removeClass();
		$('#CategoryOrderInt').addClass(categoryNo);
		
		window.scrollTo(0, 0);
	}
	if (path == '/wishRestaurantList/previous') {
		page = $('#PageInt').attr('class');
		order = $('#OrderInt').attr('class');
		console.log('order:' + order);
		let previousValue = parseInt(page)-1
		let orderValue = parseInt(order);
		let categoryNoValue = parseInt(categoryNo);
		console.log('orderValue:' + orderValue);
		let sendJsonObject = {
			page : previousValue,
			order : orderValue,
			categoryNo : categoryNoValue
		}
		let responseObject = ajaxRequest('POST','wish/restaurantlist',sendJsonObject);
		html = wish_restaurantList_form(responseObject);
		$('#content2').html(html);
		$('#PageInt').addClass(String(previousValue));
		$('#OrderInt').addClass(order);
		$('#CategoryOrderInt').removeClass();
		$('#CategoryOrderInt').addClass(categoryNo);
		
		window.scrollTo(0, 0);
	}
	if (path == '/wishRestaurantList/next') {
		page = $('#PageInt').attr('class');
		order = $('#OrderInt').attr('class');
		let nextvalue = parseInt(page)+1
		let orderValue = parseInt(order);
		let categoryNoValue = parseInt(categoryNo);
		let sendJsonObject = {
			page : nextvalue,
			order : orderValue,
			categoryNo : categoryNoValue
		}
		let responseObject = ajaxRequest('POST','wish/restaurantlist',sendJsonObject);
		console.log(responseObject);
		html = wish_restaurantList_form(responseObject);
		$('#content2').html(html);
		$('#PageInt').addClass(String(nextvalue));
		$('#OrderInt').addClass(order);
		$('#CategoryOrderInt').removeClass();
		$('#CategoryOrderInt').addClass(categoryNo);
		
		window.scrollTo(0, 0);
	}
	// 호텔
	if (path == '/wishHotelList/page/'+page) {
		let categoryNoInt = parseInt(categoryNo);
		let sendJsonObject = {
			page : page,
			order : order,
			categoryNo : categoryNoInt
		}
		let responseObject = ajaxRequest('POST','wish/hotellist',sendJsonObject);
		console.log(responseObject);
		html = wish_HotelList_form(responseObject);
		$('#content2').html(html);
		$('#PageInt').addClass(page);
		$('#OrderInt').addClass(order);
		$('#CategoryOrderInt').removeClass();
		$('#CategoryOrderInt').addClass(categoryNo);
		
		window.scrollTo(0, 0);
	}
	if (path == '/wishHotelList/previous') {
		page = $('#PageInt').attr('class');
		order = $('#OrderInt').attr('class');
		console.log('order:' + order);
		let previousValue = parseInt(page)-1
		let orderValue = parseInt(order);
		let categoryNoValue = parseInt(categoryNo);
		console.log('orderValue:' + orderValue);
		let sendJsonObject = {
			page : previousValue,
			order : orderValue,
			categoryNo : categoryNoValue
		}
		let responseObject = ajaxRequest('POST','wish/hotellist',sendJsonObject);
		html = wish_HotelList_form(responseObject);
		$('#content2').html(html);
		$('#PageInt').addClass(String(previousValue));
		$('#OrderInt').addClass(order);
		$('#CategoryOrderInt').removeClass();
		$('#CategoryOrderInt').addClass(categoryNo);
		
		window.scrollTo(0, 0);
	}
	if (path == '/wishHotelList/next') {
		page = $('#PageInt').attr('class');
		order = $('#OrderInt').attr('class');
		let nextvalue = parseInt(page)+1
		let orderValue = parseInt(order);
		let categoryNoValue = parseInt(categoryNo);
		let sendJsonObject = {
			page : nextvalue,
			order : orderValue,
			categoryNo : categoryNoValue
		}
		let responseObject = ajaxRequest('POST','wish/hotellist',sendJsonObject);
		console.log(responseObject);
		html = wish_HotelList_form(responseObject);
		$('#content2').html(html);
		$('#PageInt').addClass(String(nextvalue));
		$('#OrderInt').addClass(order);
		$('#CategoryOrderInt').removeClass();
		$('#CategoryOrderInt').addClass(categoryNo);
		
		window.scrollTo(0, 0);
	}
	// 명소
	if (path == '/wishAttractionList/page/'+page) {
		console.log('위시');
		let categoryNoInt = parseInt(categoryNo);
		let sendJsonObject = {
			page : page,
			order : order,
			categoryNo : categoryNoInt
		}
		let responseObject = ajaxRequest('POST','wish/attractionlist',sendJsonObject);
		console.log(responseObject);
		html = wish_attractionList_form(responseObject);
		$('#content2').html(html);
		$('#PageInt').addClass(page);
		$('#OrderInt').addClass(order);
		$('#CategoryOrderInt').removeClass();
		$('#CategoryOrderInt').addClass(categoryNo);
		
		window.scrollTo(0, 0);
	}
	if (path == '/wishAttractionList/previous') {
		page = $('#PageInt').attr('class');
		order = $('#OrderInt').attr('class');
		console.log('order:' + order);
		let previousValue = parseInt(page)-1
		let orderValue = parseInt(order);
		let categoryNoValue = parseInt(categoryNo);
		console.log('orderValue:' + orderValue);
		let sendJsonObject = {
			page : previousValue,
			order : orderValue,
			categoryNo : categoryNoValue
		}
		let responseObject = ajaxRequest('POST','wish/attractionlist',sendJsonObject);
		html = wish_attractionList_form(responseObject);
		$('#content2').html(html);
		$('#PageInt').addClass(String(previousValue));
		$('#OrderInt').addClass(order);
		$('#CategoryOrderInt').removeClass();
		$('#CategoryOrderInt').addClass(categoryNo);
		
		window.scrollTo(0, 0);
	}
	if (path == '/wishAttractionList/next') {
		page = $('#PageInt').attr('class');
		order = $('#OrderInt').attr('class');
		let nextvalue = parseInt(page)+1
		let orderValue = parseInt(order);
		let categoryNoValue = parseInt(categoryNo);
		let sendJsonObject = {
			page : nextvalue,
			order : orderValue,
			categoryNo : categoryNoValue
		}
		let responseObject = ajaxRequest('POST','wish/attractionlist',sendJsonObject);
		console.log(responseObject);
		html = wish_attractionList_form(responseObject);
		$('#content2').html(html);
		$('#PageInt').addClass(String(nextvalue));
		$('#OrderInt').addClass(order);
		$('#CategoryOrderInt').removeClass();
		$('#CategoryOrderInt').addClass(categoryNo);
		
		window.scrollTo(0, 0);
	}
}

init();
