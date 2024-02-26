export function wish_HotelList_form(responseJsonObject = {}) {
	let htmlTemplate =
	`
         				
         			<style>
			/******이미지 사이즈 고정******/
			.fixed-size-image {
   			 width: 300px; /* 원하는 가로 크기 */
   			 height: 230px; /* 원하는 세로 크기 */
    		object-fit: cover; /* 이미지가 지정한 크기로 맞춰지면서 비율 유지 */
			}
		</style>
         				
         				
                        <!-- Shop-control-bar Title -->
                        <div class="d-flex justify-content-between align-items-center mb-4">
                            <h3 class="font-size-21 font-weight-bold mb-0 text-lh-1">위시리스트</h3>
                            <!--<ul class="nav tab-nav-shop" id="pills-tab" role="tablist">
                               <li class="nav-item">
                                    <a class="nav-link font-size-22 p-0" id="pills-three-example1-tab" data-toggle="pill" href="#pills-three-example1" role="tab" aria-controls="pills-three-example1" aria-selected="true">
                                        <div class="d-md-flex justify-content-md-center align-items-md-center">
                                            <i class="fa fa-list"></i>
                                        </div>
                                    </a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link font-size-22 p-0 ml-2 active" id="pills-one-example1-tab" data-toggle="pill" href="#pills-one-example1" role="tab" aria-controls="pills-one-example1" aria-selected="false">
                                        <div class="d-md-flex justify-content-md-center align-items-md-center">
                                            <i class="fa fa-th"></i>
                                        </div>
                                    </a>
                                </li>
                            </ul>-->
                        </div>
                        <!-- End shop-control-bar Title -->

                        <!-- Slick Tab carousel -->
                        <div class="u-slick__tab">
                            <!-- Nav Links -->
                            
                            
                            
                            
                            <!--정렬바-->
                            <div class="mb-5">
                                <ul class="nav flex-nowrap border border-radius-3 tab-nav align-items-center py-2 px-0" role="tablist">
                                    <li class="nav-item d-flex align-items-center flex-shrink-0 flex-xl-shrink-1">
                                        <a class="nav-link font-weight-normal text-lh-1dot6 py-1 px-4 px-wd-5 font-weight-normal font-size-15" href="wishHotel?page=1">숙소
                                        </a>
                                    </li>
                                    <li class="nav-item d-flex align-items-center flex-shrink-0 flex-xl-shrink-1 border-left">
                                       <a class="nav-link font-weight-normal text-gray-1 text-lh-1dot6 py-1 px-4 px-wd-5 font-weight-normal font-size-15" href="wishAttraction?page=1">명소
                                        </a>
                                        <!--<select class="js-select selectpicker dropdown-select bootstrap-select__custom-nav w-auto" data-style="btn-sm py-1 px-4 px-wd-5 font-weight-normal font-size-15  text-gray-1 d-flex align-items-center">
                                          <option value="one" selected>Price</option>
                                          <option value="two">Two</option>
                                          <option value="three">Three</option>
                                          <option value="four">Four</option>
                                        </select>-->
                                    </li>
                                    <li class="nav-item d-flex align-items-center flex-shrink-0 flex-xl-shrink-1 border-left">
                                       <a class="nav-link font-weight-normal text-gray-1 text-lh-1dot6 py-1 px-4 px-wd-5 font-weight-normal font-size-15" href="wishRestaurant?page=1">식당
                                        </a>
                                       <!-- <select class="js-select selectpicker dropdown-select bootstrap-select__custom-nav w-auto" data-style="btn-sm py-1 px-4 px-wd-5 font-weight-normal font-size-15  text-gray-1 d-flex align-items-center">
                                          <option value="one" selected>Stars</option>
                                          <option value="two">Two</option>
                                          <option value="three">Three</option>
                                          <option value="four">Four</option>
                                        </select>-->
                                    </li>
                                    <!--
                                    <li class="nav-item d-flex align-items-center flex-shrink-0 flex-xl-shrink-1 border-left">
                                        <a id="HotelRowPrice" class="nav-link font-weight-normal text-gray-1 text-lh-1dot6 py-1 px-4 px-wd-5 font-weight-normal font-size-15 ">가격낮은순
                                        </a>
                                    </li>
                                    -->
                                    <!--
                                    <li class="nav-item d-flex align-items-center flex-shrink-0 flex-xl-shrink-1 border-left">
                                        <a id="HotelTopStar" class="nav-link font-weight-normal text-gray-1 text-lh-1dot6 py-1 px-4 px-wd-5 font-weight-normal font-size-15 ">별점순
                                        </a>
                                    </li>
                                    -->
                                    <!--<li class="nav-item d-flex align-items-center flex-shrink-0 flex-xl-shrink-1 border-left">
                                        <a href="#" class="nav-link font-weight-normal text-gray-1 text-lh-1dot6 py-1 px-4 px-wd-5 font-weight-normal font-size-15 ">Top Reviewed
                                        </a>
                                    </li>-->
                                </ul>
                            </div>
                            <!--정렬바 끝-->
                            
                            
                            
                            
                            <!-- End Nav Links -->

                            <!-- Tab Content -->
                            <div class="tab-content" id="pills-tabContent">
                                <div class="tab-pane fade mb-5 mb-xl-0" id="pills-three-example1" role="tabpanel" aria-labelledby="pills-three-example1-tab" data-target-group="groups">
                                    <ul class="d-block list-unstyled products-group prodcut-list-view">
                                        <li class="card mb-5 overflow-hidden">
                                            <div class="product-item__outer w-100">
                                                <div class="row">
                                                    <div class="col-md-5 col-lg-6 col-xl-4">
                                                        <div class="product-item__header">
                                                            <div class="position-relative">
                                                                <div class="js-slick-carousel u-slick u-slick--equal-height "
                                                                    data-slides-show="1"
                                                                    data-slides-scroll="1"
                                                                    data-arrows-classes="d-none d-lg-inline-block u-slick__arrow-classic v4 u-slick__arrow-classic--v4 u-slick__arrow-centered--y rounded-circle"
                                                                    data-arrow-left-classes="flaticon-back u-slick__arrow-classic-inner u-slick__arrow-classic-inner--left"
                                                                    data-arrow-right-classes="flaticon-next u-slick__arrow-classic-inner u-slick__arrow-classic-inner--right"
                                                                    data-pagi-classes="js-pagination text-center u-slick__pagination u-slick__pagination--white position-absolute right-0 bottom-0 left-0 mb-3 mb-0">
                                                                    <div class="js-slide">
                                                                        <a href="../rental/rental-single-v1.html" class="d-block gradient-overlay-half-bg-gradient-v5"><img class="img-fluid" src="assets/img/300x230/img17.jpg"></a>
                                                                    </div>
                                                                    <div class="js-slide">
                                                                        <a href="../rental/rental-single-v1.html" class="d-block gradient-overlay-half-bg-gradient-v5"><img class="img-fluid" src="assets/img/300x230/img18.jpg"></a>
                                                                    </div>
                                                                    <div class="js-slide">
                                                                        <a href="../rental/rental-single-v1.html" class="d-block gradient-overlay-half-bg-gradient-v5"><img class="img-fluid" src="assets/img/300x230/img19.jpg"></a>
                                                                    </div>
                                                                    <div class="js-slide">
                                                                        <a href="../rental/rental-single-v1.html" class="d-block gradient-overlay-half-bg-gradient-v5"><img class="img-fluid" src="assets/img/300x230/img20.jpg"></a>
                                                                    </div>
                                                                    <div class="js-slide">
                                                                        <a href="../rental/rental-single-v1.html" class="d-block gradient-overlay-half-bg-gradient-v5"><img class="img-fluid" src="assets/img/300x230/img38.jpg"></a>
                                                                    </div>
                                                                    <div class="js-slide">
                                                                        <a href="../rental/rental-single-v1.html" class="d-block gradient-overlay-half-bg-gradient-v5"><img class="img-fluid" src="assets/img/300x230/img39.jpg"></a>
                                                                    </div>
                                                                </div>

                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col col-md-7 col-lg-6 col-xl-5 flex-horizontal-center">
                                                        <div class="w-100 position-relative m-4 m-md-0">
                                                            <div class="position-absolute top-0 right-0 pr-md-3 d-none d-md-block">
                                                                <button type="button" class="btn btn-sm btn-icon rounded-circle" data-toggle="tooltip" data-placement="top" title="" data-original-title="Save for later">
                                                                    <span class="flaticon-heart-1 font-size-20"></span>
                                                                </button>
                                                            </div>
                                                            <a href="../rental/rental-single-v1.html">
                                                                <span class="font-weight-bold font-size-17 text-dark text-dark">Comfortable Office Space</span>
                                                            </a>
                                                            <div class="card-body p-0 mt-2">
                                                                <a href="../rental/rental-single-v1.html" class="d-block">
                                                                    <div class="d-flex align-items-center font-size-14 text-gray-1">
                                                                        <i class="icon flaticon-placeholder mr-2 font-size-20"></i> Greater London, United Kingdom
                                                                    </div>
                                                                </a>
                                                                <div class="mt-1">
                                                                    <span class="py-1 font-size-14 border-radius-3 font-weight-normal pagination-v2-arrow-color">2.5/5 Excellant</span>
                                                                    <span class="font-size-14 text-gray-1 ml-2">48 reviews</span>
                                                                </div>
                                                            </div>
                                                            <div class="mt-2 py-2">
                                                                <div class="d-flex">
                                                                    <div class="ml-0">
                                                                        <ul class="list-unstyled mb-0">
                                                                            <li class="media mb-2 text-gray-1">
                                                                                <small class="mr-2">
                                                                                    <small class="flaticon-plans font-size-16"></small>
                                                                                </small>
                                                                                <div class="media-body font-size-1">
                                                                                    4800 sq ft
                                                                                </div>
                                                                            </li>
                                                                            <li class="media mb-2 text-gray-1">
                                                                                <small class="mr-2">
                                                                                    <small class="flaticon-bathtub font-size-16"></small>
                                                                                </small>
                                                                                <div class="media-body font-size-1">
                                                                                    2 bathrooms
                                                                                </div>
                                                                            </li>
                                                                        </ul>
                                                                    </div>
                                                                    <div class="ml-5">
                                                                        <ul class="list-unstyled mb-0">
                                                                            <li class="media mb-2 text-gray-1">
                                                                                <small class="mr-2">
                                                                                    <small class="flaticon-door font-size-16"></small>
                                                                                </small>
                                                                                <div class="media-body font-size-1">
                                                                                    4 Rooms
                                                                                </div>
                                                                            </li>
                                                                            <li class="media mb-2 text-gray-1">
                                                                                <small class="mr-2">
                                                                                    <small class="flaticon-bed-1 font-size-16"></small>
                                                                                </small>
                                                                                <div class="media-body font-size-1">
                                                                                    6 Beds
                                                                                </div>
                                                                            </li>
                                                                        </ul>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col col-xl-3 align-self-center py-4 py-xl-0 border-top border-xl-top-0">
                                                        <div class="flex-content-center border-xl-left py-xl-5 ml-4 ml-xl-0 justify-content-start justify-content-xl-center">
                                                            <div class="text-center my-xl-1">
                                                                <div class="mb-2 pb-1">
                                                                    <span class="font-weight-bold font-size-22">£899.00</span>
                                                                    <span class="font-size-14"> / night</span>
                                                                </div>
                                                                <a href="../rental/rental-single-v1.html" class="btn btn-outline-primary d-flex align-items-center justify-content-center font-weight-bold min-height-50 border-radius-3 border-width-2 px-2 px-5 py-2">View Detail</a>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </li>
                                        <li class="card mb-5 overflow-hidden">
                                            <div class="product-item__outer w-100">
                                                <div class="row align-items-center">
                                                    <div class="col-md-5 col-lg-6 col-xl-4">
                                                        <div class="product-item__header">
                                                            <div class="position-relative">
                                                                <div class="js-slick-carousel u-slick u-slick--equal-height "
                                                                    data-slides-show="1"
                                                                    data-slides-scroll="1"
                                                                    data-arrows-classes="d-none d-lg-inline-block u-slick__arrow-classic v4 u-slick__arrow-classic--v4 u-slick__arrow-centered--y rounded-circle"
                                                                    data-arrow-left-classes="flaticon-back u-slick__arrow-classic-inner u-slick__arrow-classic-inner--left"
                                                                    data-arrow-right-classes="flaticon-next u-slick__arrow-classic-inner u-slick__arrow-classic-inner--right"
                                                                    data-pagi-classes="js-pagination text-center u-slick__pagination u-slick__pagination--white position-absolute right-0 bottom-0 left-0 mb-3 mb-0">
                                                                    <div class="js-slide">
                                                                        <a href="../rental/rental-single-v1.html" class="d-block gradient-overlay-half-bg-gradient-v5"><img class="img-fluid" src="assets/img/300x230/img18.jpg"></a>
                                                                    </div>
                                                                    <div class="js-slide">
                                                                        <a href="../rental/rental-single-v1.html" class="d-block gradient-overlay-half-bg-gradient-v5"><img class="img-fluid" src="assets/img/300x230/img17.jpg"></a>
                                                                    </div>
                                                                    <div class="js-slide">
                                                                        <a href="../rental/rental-single-v1.html" class="d-block gradient-overlay-half-bg-gradient-v5"><img class="img-fluid" src="assets/img/300x230/img19.jpg"></a>
                                                                    </div>
                                                                    <div class="js-slide">
                                                                        <a href="../rental/rental-single-v1.html" class="d-block gradient-overlay-half-bg-gradient-v5"><img class="img-fluid" src="assets/img/300x230/img20.jpg"></a>
                                                                    </div>
                                                                    <div class="js-slide">
                                                                        <a href="../rental/rental-single-v1.html" class="d-block gradient-overlay-half-bg-gradient-v5"><img class="img-fluid" src="assets/img/300x230/img38.jpg"></a>
                                                                    </div>
                                                                    <div class="js-slide">
                                                                        <a href="../rental/rental-single-v1.html" class="d-block gradient-overlay-half-bg-gradient-v5"><img class="img-fluid" src="assets/img/300x230/img39.jpg"></a>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col col-md-7 col-lg-6 col-xl-5 flex-horizontal-center">
                                                        <div class="w-100 position-relative m-4 m-md-0">
                                                            <div class="position-absolute top-0 right-0 pr-md-3 d-none d-md-block">
                                                                <button type="button" class="btn btn-sm btn-icon rounded-circle" data-toggle="tooltip" data-placement="top" title="" data-original-title="Save for later">
                                                                    <span class="flaticon-heart-1 font-size-20"></span>
                                                                </button>
                                                            </div>
                                                            <a href="../rental/rental-single-v1.html">
                                                                <span class="font-weight-bold font-size-17 text-dark">Sunny, Modern room in Village!</span>
                                                            </a>
                                                            <div class="card-body p-0 mt-2">
                                                                <a href="../rental/rental-single-v1.html" class="d-block">
                                                                    <div class="d-flex align-items-center font-size-14 text-gray-1">
                                                                        <i class="icon flaticon-placeholder mr-2 font-size-20"></i> Greater London, United Kingdom
                                                                    </div>
                                                                </a>
                                                                <div class="mt-1">
                                                                    <span class="py-1 font-size-14 border-radius-3 font-weight-normal pagination-v2-arrow-color">2.5/5 Excellant</span>
                                                                    <span class="font-size-14 text-gray-1 ml-2">48 reviews</span>
                                                                </div>
                                                            </div>
                                                            <div class="mt-2 py-2">
                                                                <div class="d-flex">
                                                                    <div class="ml-0">
                                                                        <ul class="list-unstyled mb-0">
                                                                            <li class="media mb-2 text-gray-1">
                                                                                <small class="mr-2">
                                                                                    <small class="flaticon-plans font-size-16"></small>
                                                                                </small>
                                                                                <div class="media-body font-size-1">
                                                                                    4800 sq ft
                                                                                </div>
                                                                            </li>
                                                                            <li class="media mb-2 text-gray-1">
                                                                                <small class="mr-2">
                                                                                    <small class="flaticon-bathtub font-size-16"></small>
                                                                                </small>
                                                                                <div class="media-body font-size-1">
                                                                                    2 bathrooms
                                                                                </div>
                                                                            </li>
                                                                        </ul>
                                                                    </div>
                                                                    <div class="ml-5">
                                                                        <ul class="list-unstyled mb-0">
                                                                            <li class="media mb-2 text-gray-1">
                                                                                <small class="mr-2">
                                                                                    <small class="flaticon-door font-size-16"></small>
                                                                                </small>
                                                                                <div class="media-body font-size-1">
                                                                                    4 Rooms
                                                                                </div>
                                                                            </li>
                                                                            <li class="media mb-2 text-gray-1">
                                                                                <small class="mr-2">
                                                                                    <small class="flaticon-bed-1 font-size-16"></small>
                                                                                </small>
                                                                                <div class="media-body font-size-1">
                                                                                    6 Beds
                                                                                </div>
                                                                            </li>
                                                                        </ul>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col col-xl-3 align-self-center py-4 py-xl-0 border-top border-xl-top-0">
                                                        <div class="flex-content-center border-xl-left py-xl-5 ml-4 ml-xl-0 justify-content-start justify-content-xl-center">
                                                            <div class="text-center my-xl-1">
                                                                <div class="mb-2 pb-1">
                                                                    <span class="font-weight-bold font-size-22">£899.00</span>
                                                                    <span class="font-size-14"> / night</span>
                                                                </div>
                                                                <a href="../rental/rental-single-v1.html" class="btn btn-outline-primary d-flex align-items-center justify-content-center font-weight-bold min-height-50 border-radius-3 border-width-2 px-2 px-5 py-2">View Detail</a>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </li>
                                        <li class="card mb-5 overflow-hidden">
                                            <div class="product-item__outer w-100">
                                                <div class="row align-items-center">
                                                    <div class="col-md-5 col-lg-6 col-xl-4">
                                                        <div class="product-item__header">
                                                            <div class="position-relative">
                                                                <div class="js-slick-carousel u-slick u-slick--equal-height "
                                                                    data-slides-show="1"
                                                                    data-slides-scroll="1"
                                                                    data-arrows-classes="d-none d-lg-inline-block u-slick__arrow-classic v4 u-slick__arrow-classic--v4 u-slick__arrow-centered--y rounded-circle"
                                                                    data-arrow-left-classes="flaticon-back u-slick__arrow-classic-inner u-slick__arrow-classic-inner--left"
                                                                    data-arrow-right-classes="flaticon-next u-slick__arrow-classic-inner u-slick__arrow-classic-inner--right"
                                                                    data-pagi-classes="js-pagination text-center u-slick__pagination u-slick__pagination--white position-absolute right-0 bottom-0 left-0 mb-3 mb-0">
                                                                    <div class="js-slide">
                                                                        <a href="../rental/rental-single-v1.html" class="d-block gradient-overlay-half-bg-gradient-v5"><img class="img-fluid" src="assets/img/300x230/img19.jpg"></a>
                                                                    </div>
                                                                    <div class="js-slide">
                                                                        <a href="../rental/rental-single-v1.html" class="d-block gradient-overlay-half-bg-gradient-v5"><img class="img-fluid" src="assets/img/300x230/img18.jpg"></a>
                                                                    </div>
                                                                    <div class="js-slide">
                                                                        <a href="../rental/rental-single-v1.html" class="d-block gradient-overlay-half-bg-gradient-v5"><img class="img-fluid" src="assets/img/300x230/img17.jpg"></a>
                                                                    </div>
                                                                    <div class="js-slide">
                                                                        <a href="../rental/rental-single-v1.html" class="d-block gradient-overlay-half-bg-gradient-v5"><img class="img-fluid" src="assets/img/300x230/img20.jpg"></a>
                                                                    </div>
                                                                    <div class="js-slide">
                                                                        <a href="../rental/rental-single-v1.html" class="d-block gradient-overlay-half-bg-gradient-v5"><img class="img-fluid" src="assets/img/300x230/img38.jpg"></a>
                                                                    </div>
                                                                    <div class="js-slide">
                                                                        <a href="../rental/rental-single-v1.html" class="d-block gradient-overlay-half-bg-gradient-v5"><img class="img-fluid" src="assets/img/300x230/img39.jpg"></a>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col col-md-7 col-lg-6 col-xl-5 flex-horizontal-center">
                                                        <div class="w-100 position-relative m-4 m-md-0">
                                                            <div class="position-absolute top-0 right-0 pr-md-3 d-none d-md-block">
                                                                <button type="button" class="btn btn-sm btn-icon rounded-circle" data-toggle="tooltip" data-placement="top" title="" data-original-title="Save for later">
                                                                    <span class="flaticon-heart-1 font-size-20"></span>
                                                                </button>
                                                            </div>
                                                            <a href="../rental/rental-single-v1.html">
                                                                <span class="font-weight-bold font-size-17 text-dark"> Large And Modern Bedroom</span>
                                                            </a>
                                                            <div class="card-body p-0 mt-2">
                                                                <a href="../rental/rental-single-v1.html" class="d-block">
                                                                    <div class="d-flex align-items-center font-size-14 text-gray-1">
                                                                        <i class="icon flaticon-placeholder mr-2 font-size-20"></i> Greater London, United Kingdom
                                                                    </div>
                                                                </a>
                                                                <div class="mt-1">
                                                                    <span class="py-1 font-size-14 border-radius-3 font-weight-normal pagination-v2-arrow-color">2.5/5 Excellant</span>
                                                                    <span class="font-size-14 text-gray-1 ml-2">48 reviews</span>
                                                                </div>
                                                            </div>
                                                            <div class="mt-2 py-2">
                                                                <div class="d-flex">
                                                                    <div class="ml-0">
                                                                        <ul class="list-unstyled mb-0">
                                                                            <li class="media mb-2 text-gray-1">
                                                                                <small class="mr-2">
                                                                                    <small class="flaticon-plans font-size-16"></small>
                                                                                </small>
                                                                                <div class="media-body font-size-1">
                                                                                    4800 sq ft
                                                                                </div>
                                                                            </li>
                                                                            <li class="media mb-2 text-gray-1">
                                                                                <small class="mr-2">
                                                                                    <small class="flaticon-bathtub font-size-16"></small>
                                                                                </small>
                                                                                <div class="media-body font-size-1">
                                                                                    2 bathrooms
                                                                                </div>
                                                                            </li>
                                                                        </ul>
                                                                    </div>
                                                                    <div class="ml-5">
                                                                        <ul class="list-unstyled mb-0">
                                                                            <li class="media mb-2 text-gray-1">
                                                                                <small class="mr-2">
                                                                                    <small class="flaticon-door font-size-16"></small>
                                                                                </small>
                                                                                <div class="media-body font-size-1">
                                                                                    4 Rooms
                                                                                </div>
                                                                            </li>
                                                                            <li class="media mb-2 text-gray-1">
                                                                                <small class="mr-2">
                                                                                    <small class="flaticon-bed-1 font-size-16"></small>
                                                                                </small>
                                                                                <div class="media-body font-size-1">
                                                                                    6 Beds
                                                                                </div>
                                                                            </li>
                                                                        </ul>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col col-xl-3 align-self-center py-4 py-xl-0 border-top border-xl-top-0">
                                                        <div class="flex-content-center border-xl-left py-xl-5 ml-4 ml-xl-0 justify-content-start justify-content-xl-center">
                                                            <div class="text-center my-xl-1">
                                                                <div class="mb-2 pb-1">
                                                                    <span class="font-weight-bold font-size-22">£899.00</span>
                                                                    <span class="font-size-14"> / night</span>
                                                                </div>
                                                                <a href="../rental/rental-single-v1.html" class="btn btn-outline-primary d-flex align-items-center justify-content-center font-weight-bold min-height-50 border-radius-3 border-width-2 px-2 px-5 py-2">View Detail</a>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </li>
                                        <li class="card mb-5 overflow-hidden">
                                            <div class="product-item__outer w-100">
                                                <div class="row align-items-center">
                                                    <div class="col-md-5 col-lg-6 col-xl-4">
                                                        <div class="product-item__header">
                                                            <div class="position-relative">
                                                                <div class="js-slick-carousel u-slick u-slick--equal-height "
                                                                    data-slides-show="1"
                                                                    data-slides-scroll="1"
                                                                    data-arrows-classes="d-none d-lg-inline-block u-slick__arrow-classic v4 u-slick__arrow-classic--v4 u-slick__arrow-centered--y rounded-circle"
                                                                    data-arrow-left-classes="flaticon-back u-slick__arrow-classic-inner u-slick__arrow-classic-inner--left"
                                                                    data-arrow-right-classes="flaticon-next u-slick__arrow-classic-inner u-slick__arrow-classic-inner--right"
                                                                    data-pagi-classes="js-pagination text-center u-slick__pagination u-slick__pagination--white position-absolute right-0 bottom-0 left-0 mb-3 mb-0">
                                                                    <div class="js-slide">
                                                                        <a href="../rental/rental-single-v1.html" class="d-block gradient-overlay-half-bg-gradient-v5"><img class="img-fluid" src="assets/img/300x230/img20.jpg"></a>
                                                                    </div>
                                                                    <div class="js-slide">
                                                                        <a href="../rental/rental-single-v1.html" class="d-block gradient-overlay-half-bg-gradient-v5"><img class="img-fluid" src="assets/img/300x230/img18.jpg"></a>
                                                                    </div>
                                                                    <div class="js-slide">
                                                                        <a href="../rental/rental-single-v1.html" class="d-block gradient-overlay-half-bg-gradient-v5"><img class="img-fluid" src="assets/img/300x230/img17.jpg"></a>
                                                                    </div>
                                                                    <div class="js-slide">
                                                                        <a href="../rental/rental-single-v1.html" class="d-block gradient-overlay-half-bg-gradient-v5"><img class="img-fluid" src="assets/img/300x230/img17.jpg"></a>
                                                                    </div>
                                                                    <div class="js-slide">
                                                                        <a href="../rental/rental-single-v1.html" class="d-block gradient-overlay-half-bg-gradient-v5"><img class="img-fluid" src="assets/img/300x230/img38.jpg"></a>
                                                                    </div>
                                                                    <div class="js-slide">
                                                                        <a href="../rental/rental-single-v1.html" class="d-block gradient-overlay-half-bg-gradient-v5"><img class="img-fluid" src="assets/img/300x230/img39.jpg"></a>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col col-md-7 col-lg-6 col-xl-5 flex-horizontal-center">
                                                        <div class="w-100 position-relative m-4 m-md-0">
                                                            <div class="position-absolute top-0 right-0 pr-md-3 d-none d-md-block">
                                                                <button type="button" class="btn btn-sm btn-icon rounded-circle" data-toggle="tooltip" data-placement="top" title="" data-original-title="Save for later">
                                                                    <span class="flaticon-heart-1 font-size-20"></span>
                                                                </button>
                                                            </div>
                                                            <a href="../rental/rental-single-v1.html">
                                                                <span class="font-weight-bold font-size-17 text-dark text-dark">Large And Modern Bedroom</span>
                                                            </a>
                                                            <div class="card-body p-0 mt-2">
                                                                <a href="../rental/rental-single-v1.html" class="d-block">
                                                                    <div class="d-flex align-items-center font-size-14 text-gray-1">
                                                                        <i class="icon flaticon-placeholder mr-2 font-size-20"></i> Greater London, United Kingdom
                                                                    </div>
                                                                </a>
                                                                <div class="mt-1">
                                                                    <span class="py-1 font-size-14 border-radius-3 font-weight-normal pagination-v2-arrow-color">2.5/5 Excellant</span>
                                                                    <span class="font-size-14 text-gray-1 ml-2">48 reviews</span>
                                                                </div>
                                                            </div>
                                                            <div class="mt-2 py-2">
                                                                <div class="d-flex">
                                                                    <div class="ml-0">
                                                                        <ul class="list-unstyled mb-0">
                                                                            <li class="media mb-2 text-gray-1">
                                                                                <small class="mr-2">
                                                                                    <small class="flaticon-plans font-size-16"></small>
                                                                                </small>
                                                                                <div class="media-body font-size-1">
                                                                                    4800 sq ft
                                                                                </div>
                                                                            </li>
                                                                            <li class="media mb-2 text-gray-1">
                                                                                <small class="mr-2">
                                                                                    <small class="flaticon-bathtub font-size-16"></small>
                                                                                </small>
                                                                                <div class="media-body font-size-1">
                                                                                    2 bathrooms
                                                                                </div>
                                                                            </li>
                                                                        </ul>
                                                                    </div>
                                                                    <div class="ml-5">
                                                                        <ul class="list-unstyled mb-0">
                                                                            <li class="media mb-2 text-gray-1">
                                                                                <small class="mr-2">
                                                                                    <small class="flaticon-door font-size-16"></small>
                                                                                </small>
                                                                                <div class="media-body font-size-1">
                                                                                    4 Rooms
                                                                                </div>
                                                                            </li>
                                                                            <li class="media mb-2 text-gray-1">
                                                                                <small class="mr-2">
                                                                                    <small class="flaticon-bed-1 font-size-16"></small>
                                                                                </small>
                                                                                <div class="media-body font-size-1">
                                                                                    6 Beds
                                                                                </div>
                                                                            </li>
                                                                        </ul>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col col-xl-3 align-self-center py-4 py-xl-0 border-top border-xl-top-0">
                                                        <div class="flex-content-center border-xl-left py-xl-5 ml-4 ml-xl-0 justify-content-start justify-content-xl-center">
                                                            <div class="text-center my-xl-1">
                                                                <div class="mb-2 pb-1">
                                                                    <span class="font-weight-bold font-size-22">£899.00</span>
                                                                    <span class="font-size-14"> / night</span>
                                                                </div>
                                                                <a href="../rental/rental-single-v1.html" class="btn btn-outline-primary d-flex align-items-center justify-content-center font-weight-bold min-height-50 border-radius-3 border-width-2 px-2 px-5 py-2">View Detail</a>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </li>
                                        <li class="card mb-5 overflow-hidden">
                                            <div class="product-item__outer w-100">
                                                <div class="row align-items-center">
                                                    <div class="col-md-5 col-lg-6 col-xl-4">
                                                        <div class="product-item__header">
                                                            <div class="position-relative">
                                                                <div class="js-slick-carousel u-slick u-slick--equal-height "
                                                                    data-slides-show="1"
                                                                    data-slides-scroll="1"
                                                                    data-arrows-classes="d-none d-lg-inline-block u-slick__arrow-classic v4 u-slick__arrow-classic--v4 u-slick__arrow-centered--y rounded-circle"
                                                                    data-arrow-left-classes="flaticon-back u-slick__arrow-classic-inner u-slick__arrow-classic-inner--left"
                                                                    data-arrow-right-classes="flaticon-next u-slick__arrow-classic-inner u-slick__arrow-classic-inner--right"
                                                                    data-pagi-classes="js-pagination text-center u-slick__pagination u-slick__pagination--white position-absolute right-0 bottom-0 left-0 mb-3 mb-0">
                                                                    <div class="js-slide">
                                                                        <a href="../rental/rental-single-v1.html" class="d-block gradient-overlay-half-bg-gradient-v5"><img class="img-fluid" src="assets/img/300x230/img38.jpg"></a>
                                                                    </div>
                                                                    <div class="js-slide">
                                                                        <a href="../rental/rental-single-v1.html" class="d-block gradient-overlay-half-bg-gradient-v5"><img class="img-fluid" src="assets/img/300x230/img18.jpg"></a>
                                                                    </div>
                                                                    <div class="js-slide">
                                                                        <a href="../rental/rental-single-v1.html" class="d-block gradient-overlay-half-bg-gradient-v5"><img class="img-fluid" src="assets/img/300x230/img19.jpg"></a>
                                                                    </div>
                                                                    <div class="js-slide">
                                                                        <a href="../rental/rental-single-v1.html" class="d-block gradient-overlay-half-bg-gradient-v5"><img class="img-fluid" src="assets/img/300x230/img20.jpg"></a>
                                                                    </div>
                                                                    <div class="js-slide">
                                                                        <a href="../rental/rental-single-v1.html" class="d-block gradient-overlay-half-bg-gradient-v5"><img class="img-fluid" src="assets/img/300x230/img17.jpg"></a>
                                                                    </div>
                                                                    <div class="js-slide">
                                                                        <a href="../rental/rental-single-v1.html" class="d-block gradient-overlay-half-bg-gradient-v5"><img class="img-fluid" src="assets/img/300x230/img39.jpg"></a>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col col-md-7 col-lg-6 col-xl-5 flex-horizontal-center">
                                                        <div class="w-100 position-relative m-4 m-md-0">
                                                            <div class="position-absolute top-0 right-0 pr-md-3 d-none d-md-block">
                                                                <button type="button" class="btn btn-sm btn-icon rounded-circle" data-toggle="tooltip" data-placement="top" title="" data-original-title="Save for later">
                                                                    <span class="flaticon-heart-1 font-size-20"></span>
                                                                </button>
                                                            </div>
                                                            <a href="../rental/rental-single-v1.html">
                                                                <span class="font-weight-bold font-size-17 text-dark">Modern Apartment With Ocean View</span>
                                                            </a>
                                                            <div class="card-body p-0 mt-2">
                                                                <a href="../rental/rental-single-v1.html" class="d-block">
                                                                    <div class="d-flex align-items-center font-size-14 text-gray-1">
                                                                        <i class="icon flaticon-placeholder mr-2 font-size-20"></i> Greater London, United Kingdom
                                                                    </div>
                                                                </a>
                                                                <div class="mt-1">
                                                                    <span class="py-1 font-size-14 border-radius-3 font-weight-normal pagination-v2-arrow-color">2.5/5 Excellant</span>
                                                                    <span class="font-size-14 text-gray-1 ml-2">48 reviews</span>
                                                                </div>
                                                            </div>
                                                            <div class="mt-2 py-2">
                                                                <div class="d-flex">
                                                                    <div class="ml-0">
                                                                        <ul class="list-unstyled mb-0">
                                                                            <li class="media mb-2 text-gray-1">
                                                                                <small class="mr-2">
                                                                                    <small class="flaticon-plans font-size-16"></small>
                                                                                </small>
                                                                                <div class="media-body font-size-1">
                                                                                    4800 sq ft
                                                                                </div>
                                                                            </li>
                                                                            <li class="media mb-2 text-gray-1">
                                                                                <small class="mr-2">
                                                                                    <small class="flaticon-bathtub font-size-16"></small>
                                                                                </small>
                                                                                <div class="media-body font-size-1">
                                                                                    2 bathrooms
                                                                                </div>
                                                                            </li>
                                                                        </ul>
                                                                    </div>
                                                                    <div class="ml-5">
                                                                        <ul class="list-unstyled mb-0">
                                                                            <li class="media mb-2 text-gray-1">
                                                                                <small class="mr-2">
                                                                                    <small class="flaticon-door font-size-16"></small>
                                                                                </small>
                                                                                <div class="media-body font-size-1">
                                                                                    4 Rooms
                                                                                </div>
                                                                            </li>
                                                                            <li class="media mb-2 text-gray-1">
                                                                                <small class="mr-2">
                                                                                    <small class="flaticon-bed-1 font-size-16"></small>
                                                                                </small>
                                                                                <div class="media-body font-size-1">
                                                                                    6 Beds
                                                                                </div>
                                                                            </li>
                                                                        </ul>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col col-xl-3 align-self-center py-4 py-xl-0 border-top border-xl-top-0">
                                                        <div class="flex-content-center border-xl-left py-xl-5 ml-4 ml-xl-0 justify-content-start justify-content-xl-center">
                                                            <div class="text-center my-xl-1">
                                                                <div class="mb-2 pb-1">
                                                                    <span class="font-weight-bold font-size-22">£899.00</span>
                                                                    <span class="font-size-14"> / night</span>
                                                                </div>
                                                                <a href="../rental/rental-single-v1.html" class="btn btn-outline-primary d-flex align-items-center justify-content-center font-weight-bold min-height-50 border-radius-3 border-width-2 px-2 px-5 py-2">View Detail</a>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </li>
                                        <li class="card mb-5 overflow-hidden">
                                            <div class="product-item__outer w-100">
                                                <div class="row align-items-center">
                                                    <div class="col-md-5 col-lg-6 col-xl-4">
                                                        <div class="product-item__header">
                                                            <div class="position-relative">
                                                                <div class="js-slick-carousel u-slick u-slick--equal-height "
                                                                    data-slides-show="1"
                                                                    data-slides-scroll="1"
                                                                    data-arrows-classes="d-none d-lg-inline-block u-slick__arrow-classic v4 u-slick__arrow-classic--v4 u-slick__arrow-centered--y rounded-circle"
                                                                    data-arrow-left-classes="flaticon-back u-slick__arrow-classic-inner u-slick__arrow-classic-inner--left"
                                                                    data-arrow-right-classes="flaticon-next u-slick__arrow-classic-inner u-slick__arrow-classic-inner--right"
                                                                    data-pagi-classes="js-pagination text-center u-slick__pagination u-slick__pagination--white position-absolute right-0 bottom-0 left-0 mb-3 mb-0">
                                                                    <div class="js-slide">
                                                                        <a href="../rental/rental-single-v2.html" class="d-block gradient-overlay-half-bg-gradient-v5"><img class="img-fluid" src="assets/img/300x230/img39.jpg"></a>
                                                                    </div>
                                                                    <div class="js-slide">
                                                                        <a href="../rental/rental-single-v2.html" class="d-block gradient-overlay-half-bg-gradient-v5"><img class="img-fluid" src="assets/img/300x230/img18.jpg"></a>
                                                                    </div>
                                                                    <div class="js-slide">
                                                                        <a href="../rental/rental-single-v2.html" class="d-block gradient-overlay-half-bg-gradient-v5"><img class="img-fluid" src="assets/img/300x230/img19.jpg"></a>
                                                                    </div>
                                                                    <div class="js-slide">
                                                                        <a href="../rental/rental-single-v2.html" class="d-block gradient-overlay-half-bg-gradient-v5"><img class="img-fluid" src="assets/img/300x230/img20.jpg"></a>
                                                                    </div>
                                                                    <div class="js-slide">
                                                                        <a href="../rental/rental-single-v2.html" class="d-block gradient-overlay-half-bg-gradient-v5"><img class="img-fluid" src="assets/img/300x230/img38.jpg"></a>
                                                                    </div>
                                                                    <div class="js-slide">
                                                                        <a href="../rental/rental-single-v2.html" class="d-block gradient-overlay-half-bg-gradient-v5"><img class="img-fluid" src="assets/img/300x230/img17.jpg"></a>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col col-md-7 col-lg-6 col-xl-5 flex-horizontal-center">
                                                        <div class="w-100 position-relative m-4 m-md-0">
                                                            <div class="position-absolute top-0 right-0 pr-md-3 d-none d-md-block">
                                                                <button type="button" class="btn btn-sm btn-icon rounded-circle" data-toggle="tooltip" data-placement="top" title="" data-original-title="Save for later">
                                                                    <span class="flaticon-heart-1 font-size-20"></span>
                                                                </button>
                                                            </div>
                                                            <a href="../rental/rental-single-v2.html">
                                                                <span class="font-weight-bold font-size-17 text-dark">Large And Modern Bedroom</span>
                                                            </a>
                                                            <div class="card-body p-0 mt-2">
                                                                <a href="../rental/rental-single-v2.html" class="d-block">
                                                                    <div class="d-flex align-items-center font-size-14 text-gray-1">
                                                                        <i class="icon flaticon-placeholder mr-2 font-size-20"></i> Greater London, United Kingdom
                                                                    </div>
                                                                </a>
                                                                <div class="mt-1">
                                                                    <span class="py-1 font-size-14 border-radius-3 font-weight-normal pagination-v2-arrow-color">2.5/5 Excellant</span>
                                                                    <span class="font-size-14 text-gray-1 ml-2">48 reviews</span>
                                                                </div>
                                                            </div>
                                                            <div class="mt-2 py-2">
                                                                <div class="d-flex">
                                                                    <div class="ml-0">
                                                                        <ul class="list-unstyled mb-0">
                                                                            <li class="media mb-2 text-gray-1">
                                                                                <small class="mr-2">
                                                                                    <small class="flaticon-plans font-size-16"></small>
                                                                                </small>
                                                                                <div class="media-body font-size-1">
                                                                                    4800 sq ft
                                                                                </div>
                                                                            </li>
                                                                            <li class="media mb-2 text-gray-1">
                                                                                <small class="mr-2">
                                                                                    <small class="flaticon-bathtub font-size-16"></small>
                                                                                </small>
                                                                                <div class="media-body font-size-1">
                                                                                    2 bathrooms
                                                                                </div>
                                                                            </li>
                                                                        </ul>
                                                                    </div>
                                                                    <div class="ml-5">
                                                                        <ul class="list-unstyled mb-0">
                                                                            <li class="media mb-2 text-gray-1">
                                                                                <small class="mr-2">
                                                                                    <small class="flaticon-door font-size-16"></small>
                                                                                </small>
                                                                                <div class="media-body font-size-1">
                                                                                    4 Rooms
                                                                                </div>
                                                                            </li>
                                                                            <li class="media mb-2 text-gray-1">
                                                                                <small class="mr-2">
                                                                                    <small class="flaticon-bed-1 font-size-16"></small>
                                                                                </small>
                                                                                <div class="media-body font-size-1">
                                                                                    6 Beds
                                                                                </div>
                                                                            </li>
                                                                        </ul>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col col-xl-3 align-self-center py-4 py-xl-0 border-top border-xl-top-0">
                                                        <div class="flex-content-center border-xl-left py-xl-5 ml-4 ml-xl-0 justify-content-start justify-content-xl-center">
                                                            <div class="text-center my-xl-1">
                                                                <div class="mb-2 pb-1">
                                                                    <span class="font-weight-bold font-size-22">£899.00</span>
                                                                    <span class="font-size-14"> / night</span>
                                                                </div>
                                                                <a href="../rental/rental-single-v1.html" class="btn btn-outline-primary d-flex align-items-center justify-content-center font-weight-bold min-height-50 border-radius-3 border-width-2 px-2 px-5 py-2">View Detail</a>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </li>
                                        <li class="card mb-5 overflow-hidden">
                                            <div class="product-item__outer w-100">
                                                <div class="row align-items-center">
                                                    <div class="col-md-5 col-lg-6 col-xl-4">
                                                        <div class="product-item__header">
                                                            <div class="position-relative">
                                                                <div class="js-slick-carousel u-slick u-slick--equal-height "
                                                                    data-slides-show="1"
                                                                    data-slides-scroll="1"
                                                                    data-arrows-classes="d-none d-lg-inline-block u-slick__arrow-classic v4 u-slick__arrow-classic--v4 u-slick__arrow-centered--y rounded-circle"
                                                                    data-arrow-left-classes="flaticon-back u-slick__arrow-classic-inner u-slick__arrow-classic-inner--left"
                                                                    data-arrow-right-classes="flaticon-next u-slick__arrow-classic-inner u-slick__arrow-classic-inner--right"
                                                                    data-pagi-classes="js-pagination text-center u-slick__pagination u-slick__pagination--white position-absolute right-0 bottom-0 left-0 mb-3 mb-0">
                                                                    <div class="js-slide">
                                                                        <a href="../rental/rental-single-v2.html" class="d-block gradient-overlay-half-bg-gradient-v5"><img class="img-fluid" src="assets/img/300x230/img17.jpg"></a>
                                                                    </div>
                                                                    <div class="js-slide">
                                                                        <a href="../rental/rental-single-v2.html" class="d-block gradient-overlay-half-bg-gradient-v5"><img class="img-fluid" src="assets/img/300x230/img18.jpg"></a>
                                                                    </div>
                                                                    <div class="js-slide">
                                                                        <a href="../rental/rental-single-v2.html" class="d-block gradient-overlay-half-bg-gradient-v5"><img class="img-fluid" src="assets/img/300x230/img19.jpg"></a>
                                                                    </div>
                                                                    <div class="js-slide">
                                                                        <a href="../rental/rental-single-v2.html" class="d-block gradient-overlay-half-bg-gradient-v5"><img class="img-fluid" src="assets/img/300x230/img20.jpg"></a>
                                                                    </div>
                                                                    <div class="js-slide">
                                                                        <a href="../rental/rental-single-v2.html" class="d-block gradient-overlay-half-bg-gradient-v5"><img class="img-fluid" src="assets/img/300x230/img38.jpg"></a>
                                                                    </div>
                                                                    <div class="js-slide">
                                                                        <a href="../rental/rental-single-v2.html" class="d-block gradient-overlay-half-bg-gradient-v5"><img class="img-fluid" src="assets/img/300x230/img39.jpg"></a>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col col-md-7 col-lg-6 col-xl-5 flex-horizontal-center">
                                                        <div class="w-100 position-relative m-4 m-md-0">
                                                            <div class="position-absolute top-0 right-0 pr-md-3 d-none d-md-block">
                                                                <button type="button" class="btn btn-sm btn-icon rounded-circle" data-toggle="tooltip" data-placement="top" title="" data-original-title="Save for later">
                                                                    <span class="flaticon-heart-1 font-size-20"></span>
                                                                </button>
                                                            </div>
                                                            <a href="../rental/rental-single-v2.html">
                                                                <span class="font-weight-bold font-size-17 text-dark">City Penthouse In Central City</span>
                                                            </a>
                                                            <div class="card-body p-0 mt-2">
                                                                <a href="../rental/rental-single-v2.html" class="d-block">
                                                                    <div class="d-flex align-items-center font-size-14 text-gray-1">
                                                                        <i class="icon flaticon-placeholder mr-2 font-size-20"></i> Greater London, United Kingdom
                                                                    </div>
                                                                </a>
                                                                <div class="mt-1">
                                                                    <span class="py-1 font-size-14 border-radius-3 font-weight-normal pagination-v2-arrow-color">2.5/5 Excellant</span>
                                                                    <span class="font-size-14 text-gray-1 ml-2">48 reviews</span>
                                                                </div>
                                                            </div>
                                                            <div class="mt-2 py-2">
                                                                <div class="d-flex">
                                                                    <div class="ml-0">
                                                                        <ul class="list-unstyled mb-0">
                                                                            <li class="media mb-2 text-gray-1">
                                                                                <small class="mr-2">
                                                                                    <small class="flaticon-plans font-size-16"></small>
                                                                                </small>
                                                                                <div class="media-body font-size-1">
                                                                                    4800 sq ft
                                                                                </div>
                                                                            </li>
                                                                            <li class="media mb-2 text-gray-1">
                                                                                <small class="mr-2">
                                                                                    <small class="flaticon-bathtub font-size-16"></small>
                                                                                </small>
                                                                                <div class="media-body font-size-1">
                                                                                    2 bathrooms
                                                                                </div>
                                                                            </li>
                                                                        </ul>
                                                                    </div>
                                                                    <div class="ml-5">
                                                                        <ul class="list-unstyled mb-0">
                                                                            <li class="media mb-2 text-gray-1">
                                                                                <small class="mr-2">
                                                                                    <small class="flaticon-door font-size-16"></small>
                                                                                </small>
                                                                                <div class="media-body font-size-1">
                                                                                    4 Rooms
                                                                                </div>
                                                                            </li>
                                                                            <li class="media mb-2 text-gray-1">
                                                                                <small class="mr-2">
                                                                                    <small class="flaticon-bed-1 font-size-16"></small>
                                                                                </small>
                                                                                <div class="media-body font-size-1">
                                                                                    6 Beds
                                                                                </div>
                                                                            </li>
                                                                        </ul>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col col-xl-3 align-self-center py-4 py-xl-0 border-top border-xl-top-0">
                                                        <div class="flex-content-center border-xl-left py-xl-5 ml-4 ml-xl-0 justify-content-start justify-content-xl-center">
                                                            <div class="text-center my-xl-1">
                                                                <div class="mb-2 pb-1">
                                                                    <span class="font-weight-bold font-size-22">£899.00</span>
                                                                    <span class="font-size-14"> / night</span>
                                                                </div>
                                                                <a href="../rental/rental-single-v1.html" class="btn btn-outline-primary d-flex align-items-center justify-content-center font-weight-bold min-height-50 border-radius-3 border-width-2 px-2 px-5 py-2">View Detail</a>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </li>
                                        <li class="card mb-5 overflow-hidden">
                                            <div class="product-item__outer w-100">
                                                <div class="row align-items-center">
                                                    <div class="col-md-5 col-lg-6 col-xl-4">
                                                        <div class="product-item__header">
                                                            <div class="position-relative">
                                                                <div class="js-slick-carousel u-slick u-slick--equal-height "
                                                                    data-slides-show="1"
                                                                    data-slides-scroll="1"
                                                                    data-arrows-classes="d-none d-lg-inline-block u-slick__arrow-classic v4 u-slick__arrow-classic--v4 u-slick__arrow-centered--y rounded-circle"
                                                                    data-arrow-left-classes="flaticon-back u-slick__arrow-classic-inner u-slick__arrow-classic-inner--left"
                                                                    data-arrow-right-classes="flaticon-next u-slick__arrow-classic-inner u-slick__arrow-classic-inner--right"
                                                                    data-pagi-classes="js-pagination text-center u-slick__pagination u-slick__pagination--white position-absolute right-0 bottom-0 left-0 mb-3 mb-0">
                                                                    <div class="js-slide">
                                                                        <a href="../rental/rental-single-v2.html" class="d-block gradient-overlay-half-bg-gradient-v5"><img class="img-fluid" src="assets/img/300x230/img18.jpg"></a>
                                                                    </div>
                                                                    <div class="js-slide">
                                                                        <a href="../rental/rental-single-v2.html" class="d-block gradient-overlay-half-bg-gradient-v5"><img class="img-fluid" src="assets/img/300x230/img18.jpg"></a>
                                                                    </div>
                                                                    <div class="js-slide">
                                                                        <a href="../rental/rental-single-v2.html" class="d-block gradient-overlay-half-bg-gradient-v5"><img class="img-fluid" src="assets/img/300x230/img19.jpg"></a>
                                                                    </div>
                                                                    <div class="js-slide">
                                                                        <a href="../rental/rental-single-v2.html" class="d-block gradient-overlay-half-bg-gradient-v5"><img class="img-fluid" src="assets/img/300x230/img20.jpg"></a>
                                                                    </div>
                                                                    <div class="js-slide">
                                                                        <a href="../rental/rental-single-v2.html" class="d-block gradient-overlay-half-bg-gradient-v5"><img class="img-fluid" src="assets/img/300x230/img38.jpg"></a>
                                                                    </div>
                                                                    <div class="js-slide">
                                                                        <a href="../rental/rental-single-v2.html" class="d-block gradient-overlay-half-bg-gradient-v5"><img class="img-fluid" src="assets/img/300x230/img39.jpg"></a>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col col-md-7 col-lg-6 col-xl-5 flex-horizontal-center">
                                                        <div class="w-100 position-relative m-4 m-md-0">
                                                            <div class="position-absolute top-0 right-0 pr-md-3 d-none d-md-block">
                                                                <button type="button" class="btn btn-sm btn-icon rounded-circle" data-toggle="tooltip" data-placement="top" title="" data-original-title="Save for later">
                                                                    <span class="flaticon-heart-1 font-size-20"></span>
                                                                </button>
                                                            </div>
                                                            <a href="../rental/rental-single-v2.html">
                                                                <span class="font-weight-bold font-size-17 text-dark text-dark">Large And Modern Bedroom</span>
                                                            </a>
                                                            <div class="card-body p-0 mt-2">
                                                                <a href="../rental/rental-single-v2.html" class="d-block">
                                                                    <div class="d-flex align-items-center font-size-14 text-gray-1">
                                                                        <i class="icon flaticon-placeholder mr-2 font-size-20"></i> Greater London, United Kingdom
                                                                    </div>
                                                                </a>
                                                                <div class="mt-1">
                                                                    <span class="py-1 font-size-14 border-radius-3 font-weight-normal pagination-v2-arrow-color">2.5/5 Excellant</span>
                                                                    <span class="font-size-14 text-gray-1 ml-2">48 reviews</span>
                                                                </div>
                                                            </div>
                                                            <div class="mt-2 py-2">
                                                                <div class="d-flex">
                                                                    <div class="ml-0">
                                                                        <ul class="list-unstyled mb-0">
                                                                            <li class="media mb-2 text-gray-1">
                                                                                <small class="mr-2">
                                                                                    <small class="flaticon-plans font-size-16"></small>
                                                                                </small>
                                                                                <div class="media-body font-size-1">
                                                                                    4800 sq ft
                                                                                </div>
                                                                            </li>
                                                                            <li class="media mb-2 text-gray-1">
                                                                                <small class="mr-2">
                                                                                    <small class="flaticon-bathtub font-size-16"></small>
                                                                                </small>
                                                                                <div class="media-body font-size-1">
                                                                                    2 bathrooms
                                                                                </div>
                                                                            </li>
                                                                        </ul>
                                                                    </div>
                                                                    <div class="ml-5">
                                                                        <ul class="list-unstyled mb-0">
                                                                            <li class="media mb-2 text-gray-1">
                                                                                <small class="mr-2">
                                                                                    <small class="flaticon-door font-size-16"></small>
                                                                                </small>
                                                                                <div class="media-body font-size-1">
                                                                                    4 Rooms
                                                                                </div>
                                                                            </li>
                                                                            <li class="media mb-2 text-gray-1">
                                                                                <small class="mr-2">
                                                                                    <small class="flaticon-bed-1 font-size-16"></small>
                                                                                </small>
                                                                                <div class="media-body font-size-1">
                                                                                    6 Beds
                                                                                </div>
                                                                            </li>
                                                                        </ul>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col col-xl-3 align-self-center py-4 py-xl-0 border-top border-xl-top-0">
                                                        <div class="flex-content-center border-xl-left py-xl-5 ml-4 ml-xl-0 justify-content-start justify-content-xl-center">
                                                            <div class="text-center my-xl-1">
                                                                <div class="mb-2 pb-1">
                                                                    <span class="font-weight-bold font-size-22">£899.00</span>
                                                                    <span class="font-size-14"> / night</span>
                                                                </div>
                                                                <a href="../rental/rental-single-v1.html" class="btn btn-outline-primary d-flex align-items-center justify-content-center font-weight-bold min-height-50 border-radius-3 border-width-2 px-2 px-5 py-2">View Detail</a>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </li>
                                        <li class="card mb-5 overflow-hidden">
                                            <div class="product-item__outer w-100">
                                                <div class="row align-items-center">
                                                    <div class="col-md-5 col-lg-6 col-xl-4">
                                                        <div class="product-item__header">
                                                            <div class="position-relative">
                                                                <div class="js-slick-carousel u-slick u-slick--equal-height "
                                                                    data-slides-show="1"
                                                                    data-slides-scroll="1"
                                                                    data-arrows-classes="d-none d-lg-inline-block u-slick__arrow-classic v4 u-slick__arrow-classic--v4 u-slick__arrow-centered--y rounded-circle"
                                                                    data-arrow-left-classes="flaticon-back u-slick__arrow-classic-inner u-slick__arrow-classic-inner--left"
                                                                    data-arrow-right-classes="flaticon-next u-slick__arrow-classic-inner u-slick__arrow-classic-inner--right"
                                                                    data-pagi-classes="js-pagination text-center u-slick__pagination u-slick__pagination--white position-absolute right-0 bottom-0 left-0 mb-3 mb-0">
                                                                    <div class="js-slide">
                                                                        <a href="../rental/rental-single-v2.html" class="d-block gradient-overlay-half-bg-gradient-v5"><img class="img-fluid" src="assets/img/300x230/img20.jpg"></a>
                                                                    </div>
                                                                    <div class="js-slide">
                                                                        <a href="../rental/rental-single-v2.html" class="d-block gradient-overlay-half-bg-gradient-v5"><img class="img-fluid" src="assets/img/300x230/img18.jpg"></a>
                                                                    </div>
                                                                    <div class="js-slide">
                                                                        <a href="../rental/rental-single-v2.html" class="d-block gradient-overlay-half-bg-gradient-v5"><img class="img-fluid" src="assets/img/300x230/img19.jpg"></a>
                                                                    </div>
                                                                    <div class="js-slide">
                                                                        <a href="../rental/rental-single-v2.html" class="d-block gradient-overlay-half-bg-gradient-v5"><img class="img-fluid" src="assets/img/300x230/img20.jpg"></a>
                                                                    </div>
                                                                    <div class="js-slide">
                                                                        <a href="../rental/rental-single-v2.html" class="d-block gradient-overlay-half-bg-gradient-v5"><img class="img-fluid" src="assets/img/300x230/img38.jpg"></a>
                                                                    </div>
                                                                    <div class="js-slide">
                                                                        <a href="../rental/rental-single-v2.html" class="d-block gradient-overlay-half-bg-gradient-v5"><img class="img-fluid" src="assets/img/300x230/img39.jpg"></a>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col col-md-7 col-lg-6 col-xl-5 flex-horizontal-center">
                                                        <div class="w-100 position-relative m-4 m-md-0">
                                                            <div class="position-absolute top-0 right-0 pr-md-3 d-none d-md-block">
                                                                <button type="button" class="btn btn-sm btn-icon rounded-circle" data-toggle="tooltip" data-placement="top" title="" data-original-title="Save for later">
                                                                    <span class="flaticon-heart-1 font-size-20"></span>
                                                                </button>
                                                            </div>
                                                            <a href="../rental/rental-single-v2.html">
                                                                <span class="font-weight-bold font-size-17 text-dark">Sunny, Modern room in Village!</span>
                                                            </a>
                                                            <div class="card-body p-0 mt-2">
                                                                <a href="../rental/rental-single-v2.html" class="d-block">
                                                                    <div class="d-flex align-items-center font-size-14 text-gray-1">
                                                                        <i class="icon flaticon-placeholder mr-2 font-size-20"></i> Greater London, United Kingdom
                                                                    </div>
                                                                </a>
                                                                <div class="mt-1">
                                                                    <span class="py-1 font-size-14 border-radius-3 font-weight-normal pagination-v2-arrow-color">2.5/5 Excellant</span>
                                                                    <span class="font-size-14 text-gray-1 ml-2">48 reviews</span>
                                                                </div>
                                                            </div>
                                                            <div class="mt-2 py-2">
                                                                <div class="d-flex">
                                                                    <div class="ml-0">
                                                                        <ul class="list-unstyled mb-0">
                                                                            <li class="media mb-2 text-gray-1">
                                                                                <small class="mr-2">
                                                                                    <small class="flaticon-plans font-size-16"></small>
                                                                                </small>
                                                                                <div class="media-body font-size-1">
                                                                                    4800 sq ft
                                                                                </div>
                                                                            </li>
                                                                            <li class="media mb-2 text-gray-1">
                                                                                <small class="mr-2">
                                                                                    <small class="flaticon-bathtub font-size-16"></small>
                                                                                </small>
                                                                                <div class="media-body font-size-1">
                                                                                    2 bathrooms
                                                                                </div>
                                                                            </li>
                                                                        </ul>
                                                                    </div>
                                                                    <div class="ml-5">
                                                                        <ul class="list-unstyled mb-0">
                                                                            <li class="media mb-2 text-gray-1">
                                                                                <small class="mr-2">
                                                                                    <small class="flaticon-door font-size-16"></small>
                                                                                </small>
                                                                                <div class="media-body font-size-1">
                                                                                    4 Rooms
                                                                                </div>
                                                                            </li>
                                                                            <li class="media mb-2 text-gray-1">
                                                                                <small class="mr-2">
                                                                                    <small class="flaticon-bed-1 font-size-16"></small>
                                                                                </small>
                                                                                <div class="media-body font-size-1">
                                                                                    6 Beds
                                                                                </div>
                                                                            </li>
                                                                        </ul>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col col-xl-3 align-self-center py-4 py-xl-0 border-top border-xl-top-0">
                                                        <div class="flex-content-center border-xl-left py-xl-5 ml-4 ml-xl-0 justify-content-start justify-content-xl-center">
                                                            <div class="text-center my-xl-1">
                                                                <div class="mb-2 pb-1">
                                                                    <span class="font-weight-bold font-size-22">£899.00</span>
                                                                    <span class="font-size-14"> / night</span>
                                                                </div>
                                                                <a href="../rental/rental-single-v1.html" class="btn btn-outline-primary d-flex align-items-center justify-content-center font-weight-bold min-height-50 border-radius-3 border-width-2 px-2 px-5 py-2">View Detail</a>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </li>
                                    </ul>
                                    <div class="text-center text-md-left font-size-14 mb-3 text-lh-1">Showing 1–15</div>
                                    <nav aria-label="Page navigation">
                                        <ul class="list-pagination-1 pagination border border-color-4 rounded-sm mb-5 mb-lg-0 overflow-auto overflow-xl-visible justify-content-md-center align-items-center py-2">
                                            <li class="page-item">
                                                <a class="page-link border-right rounded-0 text-gray-5" href="#" aria-label="Previous">
                                                    <i class="flaticon-left-direction-arrow font-size-10 font-weight-bold"></i>
                                                    <span class="sr-only">Previous</span>
                                                </a>
                                            </li>
                                            <li class="page-item"><a class="page-link font-size-14" href="#">1</a></li>
                                            <li class="page-item"><a class="page-link font-size-14 active" href="#">2</a></li>
                                            <li class="page-item"><a class="page-link font-size-14" href="#">3</a></li>
                                            <li class="page-item"><a class="page-link font-size-14" href="#">4</a></li>
                                            <li class="page-item"><a class="page-link font-size-14" href="#">5</a></li>
                                            <li class="page-item disabled"><a class="page-link font-size-14" href="#">...</a></li>
                                            <li class="page-item"><a class="page-link font-size-14" href="#">66</a></li>
                                            <li class="page-item"><a class="page-link font-size-14" href="#">67</a></li>
                                            <li class="page-item">
                                                <a class="page-link border-left rounded-0 text-gray-5" href="#" aria-label="Next">
                                                    <i class="flaticon-right-thin-chevron font-size-10 font-weight-bold"></i>
                                                    <span class="sr-only">Next</span>
                                                </a>
                                            </li>
                                        </ul>
                                    </nav>
                                </div>
                                <div class="tab-pane fade mb-5 mb-xl-0 show active" id="pills-one-example1" role="tabpanel" aria-labelledby="pills-one-example1-tab" data-target-group="groups">
                                    <div class="row">
										
										
										
										
										
										
										
										<!-- 여기서부터 -->
										{{#ifCond this.[0].hotelNo '>' 0}}
										{{#each this}}
                                        <div class="col-md-6 col-xl-4 mb-3 mb-md-4 pb-1">
                                            <div class="card transition-3d-hover shadow-hover-2">
                                                <div class="position-relative">
                                                    <a href="hotelDetail?hotelNo={{hotelNo}}" class="d-block gradient-overlay-half-bg-gradient-v5">
                                                        <img class="card-img-top fixed-size-image" src="assets/img/hotelImage/{{hotelImageDto.[0].imageName}}">
                                                    </a>
                                                    <div class="position-absolute top-0 right-0 pt-5 pr-3">
                                                    {{#ifCond (session.userNo) '!==' null}}
                                                      <button type="button" class="btn btn-sm btn-icon text-white rounded-circle" data-toggle="tooltip" data-placement="top" title="" data-original-title="Save for later">
                                                         {{#ifCond wishBool '==' false}}
                                                        	<span class="wishHeartHotelInsert flaticon-heart-1 font-size-20" dataNo="{{hotelNo}}"></span>
                                                      	{{else}}
                                                      		<span class="wishHeartHotelDelete fi fi-ss-heart font-size-20 text-danger" dataNo="{{hotelNo}}"></span>
                                                      	{{/ifCond}}
                                                      </button>
                                                    {{/ifCond}}
                                                    </div>
                                                    <div class="position-absolute bottom-0 left-0 right-0">
                                                        <div class="px-3 pb-2">
                                                            <a href="hotelDetail?hotelNo={{hotelNo}}">
                                                                <span class="text-white font-weight-bold font-size-17">{{hotelName}}</span>
                                                            </a>
                                                            <div class="text-white my-2">
                                                                <span class="mr-1 font-size-14">가격</span>
                                                                <span class="font-weight-bold font-size-19">{{hotelPrice}}</span>
                                                                <span class="mr-1 font-size-14">/ 1박 기준</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="position-absolute top-0 left-0 pt-5 pl-3">
                                                   <!-- <a href="../rental/rental-single-v1.html">
                                                        <span class="badge badge-pill bg-white text-primary px-3 py-2 font-size-14 font-weight-normal">Featured</span>
                                                    </a>-->
                                                </div>
                                                <div class="card-body px-4 py-3 border-bottom">
                                                    <a href="hotelDetail?hotelNo={{hotelNo}}" class="d-block">
                                                        <div class="d-flex align-items-center font-size-14 text-gray-1">
                                                            <i class="icon flaticon-placeholder mr-2 font-size-20"></i> 
                                                            {{hotelLocal}}
                                                        </div>
                                                    </a>
                                                    <div class="mt-1">
                                                        <span class="py-1 font-size-14 border-radius-3 font-weight-normal pagination-v2-arrow-color">{{formatNumber hotelStar}} / 5.0점</span>
                                                        <span class="font-size-14 text-gray-1 ml-2">( 리뷰 {{reviewSize}}개 )</span>
                                                    </div>
                                                </div>
                                                <div class="px-4 pt-3 pb-2">
                                                    <div class="row">
                                                        <div class="col-6">
                                                            <ul class="list-unstyled mb-0">
                                                               {{#ifCond hotelCategoryItems.[0].hcName '==' '오션뷰'}}
                                                                <li class="media mb-2 text-gray-1 align-items-center">
                                                                    <small class="mr-2">
																		<img src="assets/img/icon/water.png" alt="oceanView"/>
																	</small>
                                                                    <div class="media-body font-size-1">
                                                                    {{hotelCategoryItems.[0].hcName}}
                                                                    </div>
                                                                </li>
                                                                {{/ifCond}}
                                                                {{#ifCond hotelCategoryItems.[1].hcName '==' '독채'}}
                                                                <li class="media mb-2 text-gray-1 align-items-center">
                                                                    <small class="mr-2">
                                                                        <img src="assets/img/icon/house-chimney-blank.png" alt="house"/>
                                                                    </small>
                                                                    <div class="media-body font-size-1">
                                                                         {{hotelCategoryItems.[1].hcName}}
                                                                    </div>
                                                                </li>
                                                                {{/ifCond}}
                                                                {{#ifCond hotelCategoryItems.[2].hcName '==' '가든뷰'}}
                                                                <li class="media mb-2 text-gray-1 align-items-center">
                                                                    <small class="mr-2">
                                                                        <img src="assets/img/icon/trees.png" alt="gardenView"/>
                                                                    </small>
                                                                    <div class="media-body font-size-1">
                                                                         {{hotelCategoryItems.[2].hcName}}
                                                                    </div>
                                                                </li>
                                                                {{/ifCond}}
                                                                {{#ifCond hotelCategoryItems.[3].hcName '==' '게스트 하우스'}}
                                                                <li class="media mb-2 text-gray-1 align-items-center">
                                                                    <small class="mr-2">
                                                                        <img src="assets/img/icon/house-chimney-heart.png" alt="guestHouse"/>
                                                                    </small>
                                                                    <div class="media-body font-size-1">
                                                                         {{hotelCategoryItems.[3].hcName}}
                                                                    </div>
                                                                </li>
                                                                {{/ifCond}}
                                                                {{#ifCond hotelCategoryItems.[4].hcName '==' '한옥'}}
                                                                <li class="media mb-2 text-gray-1 align-items-center">
                                                                    <small class="mr-2">
                                                                        <img src="assets/img/icon/bukchon-hanok.png" alt="hanok"/>
                                                                    </small>
                                                                    <div class="media-body font-size-1">
                                                                         {{hotelCategoryItems.[4].hcName}}
                                                                    </div>
                                                                </li>
                                                                {{/ifCond}}
                                                                {{#ifCond hotelCategoryItems.[5].hcName '==' '풀빌라'}}
                                                                <li class="media mb-2 text-gray-1 align-items-center">
                                                                    <small class="mr-2">
                                                                        <img src="assets/img/icon/umbrella.png" alt="poolHouse"/>
                                                                    </small>
                                                                    <div class="media-body font-size-1">
                                                                         {{hotelCategoryItems.[5].hcName}}
                                                                    </div>
                                                                </li>
                                                                {{/ifCond}}
                                                            </ul>
                                                        </div>
                                                        <div class="col-6">
                                                            <ul class="list-unstyled mb-0">
                                                               {{#ifCond hotelCategoryItems.[6].hcName '==' '동쪽'}}
                                                                <li class="media mb-2 text-gray-1 align-items-center">
                                                                    <small class="mr-2">
                                                                       <img src="assets/img/icon/compass.png" alt="compass"/>
                                                                    </small>
                                                                    <div class="media-body font-size-1">
                                                                         {{hotelCategoryItems.[6].hcName}}
                                                                    </div>
                                                                </li>
                                                                {{/ifCond}}
                                                            	{{#ifCond hotelCategoryItems.[7].hcName '==' '서쪽'}}
                                                                <li class="media mb-2 text-gray-1 align-items-center">
                                                                    <small class="mr-2">
                                                                        <img src="assets/img/icon/compass.png" alt="compass"/>
                                                                    </small>
                                                                    <div class="media-body font-size-1">
                                                                         {{hotelCategoryItems.[7].hcName}}
                                                                    </div>
                                                                </li>
                                                                {{/ifCond}}
                                                            	{{#ifCond hotelCategoryItems.[8].hcName '==' '남쪽'}}
                                                                <li class="media mb-2 text-gray-1 align-items-center">
                                                                    <small class="mr-2">
                                                                        <img src="assets/img/icon/compass.png" alt="compass"/>
                                                                    </small>
                                                                    <div class="media-body font-size-1">
                                                                         {{hotelCategoryItems.[8].hcName}}
                                                                    </div>
                                                                </li>
                                                                {{/ifCond}}
                                                            	{{#ifCond hotelCategoryItems.[9].hcName '==' '북쪽'}}
                                                                <li class="media mb-2 text-gray-1 align-items-center">
                                                                    <small class="mr-2">
                                                                       <img src="assets/img/icon/compass.png" alt="compass"/>
                                                                    </small>
                                                                    <div class="media-body font-size-1">
                                                                         {{hotelCategoryItems.[9].hcName}}
                                                                    </div>
                                                                </li>
                                                                {{/ifCond}}
                                                            	{{#ifCond hotelCategoryItems.[10].hcName '==' '자쿠지'}}
                                                                <li class="media mb-2 text-gray-1 align-items-center">
                                                                    <small class="mr-2">
                                                                       <img src="assets/img/icon/bath.png" alt="bath"/>
                                                                    </small>
                                                                    <div class="media-body font-size-1">
                                                                         {{hotelCategoryItems.[10].hcName}}
                                                                    </div>
                                                                </li>
                                                                {{/ifCond}}
                                                            	{{#ifCond hotelCategoryItems.[11].hcName '==' '펜션'}}
                                                                <li class="media mb-2 text-gray-1 align-items-center">
                                                                    <small class="mr-2">
                                                                        <img src="assets/img/icon/house.png" alt="pension"/>
                                                                    </small>
                                                                    <div class="media-body font-size-1">
                                                                         {{hotelCategoryItems.[11].hcName}}
                                                                    </div>
                                                                </li>
                                                                {{/ifCond}}
                                                            	{{#ifCond hotelCategoryItems.[12].hcName '==' '공항 근처'}}
                                                                <li class="media mb-2 text-gray-1 align-items-center">
                                                                    <small class="mr-2">
                                                                        <img src="assets/img/icon/airport-tower.png" alt="airport"/>
                                                                    </small>
                                                                    <div class="media-body font-size-1">
                                                                         {{hotelCategoryItems.[12].hcName}}
                                                                    </div>
                                                                </li>
                                                                {{/ifCond}}
                                                            </ul>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        {{/each}}
                                        {{else}}
                                        {{/ifCond}}
                                        <!-- 여기까지 -->
                                       <!-- <div class="col-md-6 col-xl-4 mb-3 mb-md-4 pb-1">
                                            <div class="card transition-3d-hover shadow-hover-2">
                                                <div class="position-relative">
                                                    <a href="../rental/rental-single-v1.html" class="d-block gradient-overlay-half-bg-gradient-v5">
                                                        <img class="card-img-top" src="assets/img/300x230/img18.jpg">
                                                    </a>
                                                    <div class="position-absolute top-0 right-0 pt-5 pr-3">
                                                      <button type="button" class="btn btn-sm btn-icon text-white rounded-circle" data-toggle="tooltip" data-placement="top" title="" data-original-title="Save for later">
                                                        <span class="flaticon-heart-1 font-size-20"></span>
                                                      </button>
                                                    </div>
                                                    <div class="position-absolute bottom-0 left-0 right-0">
                                                        <div class="px-3 pb-2">
                                                            <a href="../rental/rental-single-v1.html">
                                                                <span class="text-white font-weight-bold font-size-17">Sunny, Modern room in Village!</span>
                                                            </a>
                                                            <div class="text-white my-2">
                                                                <span class="mr-1 font-size-14">From</span>
                                                                <span class="font-weight-bold font-size-19">£350.00</span>
                                                                <span class="mr-1 font-size-14">/ night</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="card-body px-4 py-3 border-bottom">
                                                    <a href="../rental/rental-single-v1.html" class="d-block">
                                                        <div class="d-flex align-items-center font-size-14 text-gray-1">
                                                            <i class="icon flaticon-placeholder mr-2 font-size-20"></i> Istanbul, Turkey
                                                        </div>
                                                    </a>
                                                    <div class="mt-1">
                                                        <span class="py-1 font-size-14 border-radius-3 font-weight-normal pagination-v2-arrow-color">2.5/5 Excellant</span>
                                                        <span class="font-size-14 text-gray-1 ml-2">48 reviews</span>
                                                    </div>
                                                </div>
                                                <div class="px-4 pt-3 pb-2">
                                                    <div class="row">
                                                        <div class="col-6">
                                                            <ul class="list-unstyled mb-0">
                                                                <li class="media mb-2 text-gray-1 align-items-center">
                                                                    <small class="mr-2">
                                                                        <small class="flaticon-plans font-size-16"></small>
                                                                    </small>
                                                                    <div class="media-body font-size-1">
                                                                        4800 sq ft
                                                                    </div>
                                                                </li>
                                                                <li class="media mb-2 text-gray-1 align-items-center">
                                                                    <small class="mr-2">
                                                                        <small class="flaticon-bathtub font-size-16"></small>
                                                                    </small>
                                                                    <div class="media-body font-size-1">
                                                                        2 bathrooms
                                                                    </div>
                                                                </li>
                                                            </ul>
                                                        </div>
                                                        <div class="col-6">
                                                            <ul class="list-unstyled mb-0">
                                                                <li class="media mb-2 text-gray-1 align-items-center">
                                                                    <small class="mr-2">
                                                                        <small class="flaticon-door font-size-16"></small>
                                                                    </small>
                                                                    <div class="media-body font-size-1">
                                                                        4 Rooms
                                                                    </div>
                                                                </li>
                                                                <li class="media mb-2 text-gray-1 align-items-center">
                                                                    <small class="mr-2">
                                                                        <small class="flaticon-bed-1 font-size-16"></small>
                                                                    </small>
                                                                    <div class="media-body font-size-1">
                                                                        6 Beds
                                                                    </div>
                                                                </li>
                                                            </ul>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-6 col-xl-4 mb-3 mb-md-4 pb-1">
                                            <div class="card transition-3d-hover shadow-hover-2">
                                                <div class="position-relative">
                                                    <a href="../rental/rental-single-v1.html" class="d-block gradient-overlay-half-bg-gradient-v5">
                                                        <img class="card-img-top" src="assets/img/300x230/img19.jpg">
                                                    </a>
                                                    <div class="position-absolute top-0 right-0 pt-5 pr-3">
                                                      <button type="button" class="btn btn-sm btn-icon text-white rounded-circle" data-toggle="tooltip" data-placement="top" title="">
                                                        <span class="flaticon-heart-1 font-size-20"></span>
                                                      </button>
                                                    </div>
                                                    <div class="position-absolute bottom-0 left-0 right-0">
                                                        <div class="px-3 pb-2">
                                                            <a href="../rental/rental-single-v1.html">
                                                                <span class="text-white font-weight-bold font-size-17"> Office Space in Downey </span>
                                                            </a>
                                                            <div class="text-white my-2">
                                                                <span class="mr-1 font-size-14">From</span>
                                                                <span class="font-weight-bold font-size-19">£350.00</span>
                                                                <span class="mr-1 font-size-14">/ night</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="card-body px-4 py-3 border-bottom">
                                                    <a href="../rental/rental-single-v1.html" class="d-block">
                                                        <div class="d-flex align-items-center font-size-14 text-gray-1">
                                                            <i class="icon flaticon-placeholder mr-2 font-size-20"></i> New York, United States
                                                        </div>
                                                    </a>
                                                    <div class="mt-1">
                                                        <span class="py-1 font-size-14 border-radius-3 font-weight-normal pagination-v2-arrow-color">2.5/5 Excellant</span>
                                                        <span class="font-size-14 text-gray-1 ml-2">48 reviews</span>
                                                    </div>
                                                </div>
                                                <div class="px-4 pt-3 pb-2">
                                                    <div class="row">
                                                        <div class="col-6">
                                                            <ul class="list-unstyled mb-0">
                                                                <li class="media mb-2 text-gray-1 align-items-center">
                                                                    <small class="mr-2">
                                                                        <small class="flaticon-plans font-size-16"></small>
                                                                    </small>
                                                                    <div class="media-body font-size-1">
                                                                        4800 sq ft
                                                                    </div>
                                                                </li>
                                                                <li class="media mb-2 text-gray-1 align-items-center">
                                                                    <small class="mr-2">
                                                                        <small class="flaticon-bathtub font-size-16"></small>
                                                                    </small>
                                                                    <div class="media-body font-size-1">
                                                                        2 bathrooms
                                                                    </div>
                                                                </li>
                                                            </ul>
                                                        </div>
                                                        <div class="col-6">
                                                            <ul class="list-unstyled mb-0">
                                                                <li class="media mb-2 text-gray-1 align-items-center">
                                                                    <small class="mr-2">
                                                                        <small class="flaticon-door font-size-16"></small>
                                                                    </small>
                                                                    <div class="media-body font-size-1">
                                                                        4 Rooms
                                                                    </div>
                                                                </li>
                                                                <li class="media mb-2 text-gray-1 align-items-center">
                                                                    <small class="mr-2">
                                                                        <small class="flaticon-bed-1 font-size-16"></small>
                                                                    </small>
                                                                    <div class="media-body font-size-1">
                                                                        6 Beds
                                                                    </div>
                                                                </li>
                                                            </ul>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-6 col-xl-4 mb-3 mb-md-4 pb-1">
                                            <div class="card transition-3d-hover shadow-hover-2">
                                                <div class="position-relative">
                                                    <a href="../rental/rental-single-v1.html" class="d-block gradient-overlay-half-bg-gradient-v5">
                                                        <img class="card-img-top" src="assets/img/300x230/img20.jpg">
                                                    </a>
                                                    <div class="position-absolute top-0 right-0 pt-5 pr-3">
                                                      <button type="button" class="btn btn-sm btn-icon text-white rounded-circle" data-toggle="tooltip" data-placement="top" title="" data-original-title="Save for later">
                                                        <span class="flaticon-heart-1 font-size-20"></span>
                                                      </button>
                                                    </div>
                                                    <div class="position-absolute bottom-0 left-0 right-0">
                                                        <div class="px-3 pb-2">
                                                            <h6 class="text-white font-weight-bold font-size-17"><a href="../rental/rental-single-v1.html">Apartment in Wellington</a></h6>
                                                            <div class="text-white my-2">
                                                                <span class="mr-1 font-size-14">From</span>
                                                                <span class="font-weight-bold font-size-19">£350.00</span>
                                                                <span class="mr-1 font-size-14">/ night</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="card-body px-4 py-3 border-bottom">
                                                    <a href="../rental/rental-single-v1.html" class="d-block">
                                                        <div class="d-flex align-items-center font-size-14 text-gray-1">
                                                            <i class="icon flaticon-placeholder mr-2 font-size-20"></i> New South Wales, Australia
                                                        </div>
                                                    </a>
                                                    <div class="mt-1">
                                                        <span class="py-1 font-size-14 border-radius-3 font-weight-normal pagination-v2-arrow-color">2.5/5 Excellant</span>
                                                        <span class="font-size-14 text-gray-1 ml-2">48 reviews</span>
                                                    </div>
                                                </div>
                                                <div class="px-4 pt-3 pb-2">
                                                    <div class="row">
                                                        <div class="col-6">
                                                            <ul class="list-unstyled mb-0">
                                                                <li class="media mb-2 text-gray-1 align-items-center">
                                                                    <small class="mr-2">
                                                                        <small class="flaticon-plans font-size-16"></small>
                                                                    </small>
                                                                    <div class="media-body font-size-1">
                                                                        4800 sq ft
                                                                    </div>
                                                                </li>
                                                                <li class="media mb-2 text-gray-1 align-items-center">
                                                                    <small class="mr-2">
                                                                        <small class="flaticon-bathtub font-size-16"></small>
                                                                    </small>
                                                                    <div class="media-body font-size-1">
                                                                        2 bathrooms
                                                                    </div>
                                                                </li>
                                                            </ul>
                                                        </div>
                                                        <div class="col-6">
                                                            <ul class="list-unstyled mb-0">
                                                                <li class="media mb-2 text-gray-1 align-items-center">
                                                                    <small class="mr-2">
                                                                        <small class="flaticon-door font-size-16"></small>
                                                                    </small>
                                                                    <div class="media-body font-size-1">
                                                                        4 Rooms
                                                                    </div>
                                                                </li>
                                                                <li class="media mb-2 text-gray-1 align-items-center">
                                                                    <small class="mr-2">
                                                                        <small class="flaticon-bed-1 font-size-16"></small>
                                                                    </small>
                                                                    <div class="media-body font-size-1">
                                                                        6 Beds
                                                                    </div>
                                                                </li>
                                                            </ul>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-6 col-xl-4 mb-3 mb-md-4 pb-1">
                                            <div class="card transition-3d-hover shadow-hover-2">
                                                <div class="position-relative">
                                                    <a href="../rental/rental-single-v1.html" class="d-block gradient-overlay-half-bg-gradient-v5">
                                                        <img class="card-img-top" src="assets/img/300x230/img38.jpg">
                                                    </a>
                                                    <div class="position-absolute top-0 right-0 pt-5 pr-3">
                                                      <button type="button" class="btn btn-sm btn-icon text-white rounded-circle" data-toggle="tooltip" data-placement="top" title="" data-original-title="Save for later">
                                                        <span class="flaticon-heart-1 font-size-20"></span>
                                                      </button>
                                                    </div>
                                                    <div class="position-absolute bottom-0 left-0 right-0">
                                                        <div class="px-3 pb-2">
                                                            <a href="../rental/rental-single-v1.html">
                                                                <span class="text-white font-weight-bold font-size-17">Sunny, Modern room in Village!</span>
                                                            </a>
                                                            <div class="text-white my-2">
                                                                <span class="mr-1 font-size-14">From</span>
                                                                <span class="font-weight-bold font-size-19">£350.00</span>
                                                                <span class="mr-1 font-size-14">/ night</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="card-body px-4 py-3 border-bottom">
                                                    <a href="../rental/rental-single-v1.html" class="d-block">
                                                        <div class="d-flex align-items-center font-size-14 text-gray-1">
                                                            <i class="icon flaticon-placeholder mr-2 font-size-20"></i> New South Wales, Australia
                                                        </div>
                                                    </a>
                                                    <div class="mt-1">
                                                        <span class="py-1 font-size-14 border-radius-3 font-weight-normal pagination-v2-arrow-color">2.5/5 Excellant</span>
                                                        <span class="font-size-14 text-gray-1 ml-2">48 reviews</span>
                                                    </div>
                                                </div>
                                                <div class="px-4 pt-3 pb-2">
                                                    <div class="row">
                                                        <div class="col-6">
                                                            <ul class="list-unstyled mb-0">
                                                                <li class="media mb-2 text-gray-1 align-items-center">
                                                                    <small class="mr-2">
                                                                        <small class="flaticon-plans font-size-16"></small>
                                                                    </small>
                                                                    <div class="media-body font-size-1">
                                                                        4800 sq ft
                                                                    </div>
                                                                </li>
                                                                <li class="media mb-2 text-gray-1 align-items-center">
                                                                    <small class="mr-2">
                                                                        <small class="flaticon-bathtub font-size-16"></small>
                                                                    </small>
                                                                    <div class="media-body font-size-1">
                                                                        2 bathrooms
                                                                    </div>
                                                                </li>
                                                            </ul>
                                                        </div>
                                                        <div class="col-6">
                                                            <ul class="list-unstyled mb-0">
                                                                <li class="media mb-2 text-gray-1 align-items-center">
                                                                    <small class="mr-2">
                                                                        <small class="flaticon-door font-size-16"></small>
                                                                    </small>
                                                                    <div class="media-body font-size-1">
                                                                        4 Rooms
                                                                    </div>
                                                                </li>
                                                                <li class="media mb-2 text-gray-1 align-items-center">
                                                                    <small class="mr-2">
                                                                        <small class="flaticon-bed-1 font-size-16"></small>
                                                                    </small>
                                                                    <div class="media-body font-size-1">
                                                                        6 Beds
                                                                    </div>
                                                                </li>
                                                            </ul>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-6 col-xl-4 mb-3 mb-md-4 pb-1">
                                            <div class="card transition-3d-hover shadow-hover-2">
                                                <div class="position-relative">
                                                    <a href="../rental/rental-single-v2.html" class="d-block gradient-overlay-half-bg-gradient-v5">
                                                        <img class="card-img-top" src="assets/img/300x230/img39.jpg">
                                                    </a>
                                                    <div class="position-absolute top-0 right-0 pt-5 pr-3">
                                                      <button type="button" class="btn btn-sm btn-icon text-white rounded-circle" data-toggle="tooltip" data-placement="top" title="" data-original-title="Save for later">
                                                        <span class="flaticon-heart-1 font-size-20"></span>
                                                      </button>
                                                    </div>
                                                    <div class="position-absolute bottom-0 left-0 right-0">
                                                        <div class="px-3 pb-2">
                                                            <a href="../rental/rental-single-v2.html">
                                                                <span class="text-white font-weight-bold font-size-17"> Office Space in Downey </span>
                                                            </a>
                                                            <div class="text-white my-2">
                                                                <span class="mr-1 font-size-14">From</span>
                                                                <span class="font-weight-bold font-size-19">£350.00</span>
                                                                <span class="mr-1 font-size-14">/ night</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="card-body px-4 py-3 border-bottom">
                                                    <a href="../rental/rental-single-v2.html" class="d-block">
                                                        <div class="d-flex align-items-center font-size-14 text-gray-1">
                                                            <i class="icon flaticon-placeholder mr-2 font-size-20"></i> New York, United States
                                                        </div>
                                                    </a>
                                                    <div class="mt-1">
                                                        <span class="py-1 font-size-14 border-radius-3 font-weight-normal pagination-v2-arrow-color">2.5/5 Excellant</span>
                                                        <span class="font-size-14 text-gray-1 ml-2">48 reviews</span>
                                                    </div>
                                                </div>
                                                <div class="px-4 pt-3 pb-2">
                                                    <div class="row">
                                                        <div class="col-6">
                                                            <ul class="list-unstyled mb-0">
                                                                <li class="media mb-2 text-gray-1 align-items-center">
                                                                    <small class="mr-2">
                                                                        <small class="flaticon-plans font-size-16"></small>
                                                                    </small>
                                                                    <div class="media-body font-size-1">
                                                                        4800 sq ft
                                                                    </div>
                                                                </li>
                                                                <li class="media mb-2 text-gray-1 align-items-center">
                                                                    <small class="mr-2">
                                                                        <small class="flaticon-bathtub font-size-16"></small>
                                                                    </small>
                                                                    <div class="media-body font-size-1">
                                                                        2 bathrooms
                                                                    </div>
                                                                </li>
                                                            </ul>
                                                        </div>
                                                        <div class="col-6">
                                                            <ul class="list-unstyled mb-0">
                                                                <li class="media mb-2 text-gray-1 align-items-center">
                                                                    <small class="mr-2">
                                                                        <small class="flaticon-door font-size-16"></small>
                                                                    </small>
                                                                    <div class="media-body font-size-1">
                                                                        4 Rooms
                                                                    </div>
                                                                </li>
                                                                <li class="media mb-2 text-gray-1 align-items-center">
                                                                    <small class="mr-2">
                                                                        <small class="flaticon-bed-1 font-size-16"></small>
                                                                    </small>
                                                                    <div class="media-body font-size-1">
                                                                        6 Beds
                                                                    </div>
                                                                </li>
                                                            </ul>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-6 col-xl-4 mb-3 mb-md-4 pb-1">
                                            <div class="card transition-3d-hover shadow-hover-2">
                                                <div class="position-relative">
                                                    <a href="../rental/rental-single-v2.html" class="d-block gradient-overlay-half-bg-gradient-v5">
                                                        <img class="card-img-top" src="assets/img/300x230/img40.jpg">
                                                    </a>
                                                    <div class="position-absolute top-0 right-0 pt-5 pr-3">
                                                      <button type="button" class="btn btn-sm btn-icon text-white rounded-circle" data-toggle="tooltip" data-placement="top" title="" data-original-title="Save for later">
                                                        <span class="flaticon-heart-1 font-size-20"></span>
                                                      </button>
                                                    </div>
                                                    <div class="position-absolute bottom-0 left-0 right-0">
                                                        <div class="px-3 pb-2">
                                                            <a href="../rental/rental-single-v2.html">
                                                                <span class="text-white font-weight-bold font-size-17"> Apartment in Wellington</span>
                                                            </a>
                                                            <div class="text-white my-2">
                                                                <span class="mr-1 font-size-14">From</span>
                                                                <span class="font-weight-bold font-size-19">£350.00</span>
                                                                <span class="mr-1 font-size-14">/ night</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="position-absolute top-0 left-0 pt-5 pl-3">
                                                    <a href="../rental/rental-single-v2.html">
                                                        <span class="badge badge-pill bg-white text-primary px-3 py-2 font-size-14 font-weight-normal">Featured</span>
                                                    </a>
                                                </div>
                                                <div class="card-body px-4 py-3 border-bottom">
                                                    <a href="../rental/rental-single-v2.html" class="d-block">
                                                        <div class="d-flex align-items-center font-size-14 text-gray-1">
                                                            <i class="icon flaticon-placeholder mr-2 font-size-20"></i> Istanbul , Turkey
                                                        </div>
                                                    </a>
                                                    <div class="mt-1">
                                                        <span class="py-1 font-size-14 border-radius-3 font-weight-normal pagination-v2-arrow-color">2.5/5 Excellant</span>
                                                        <span class="font-size-14 text-gray-1 ml-2">48 reviews</span>
                                                    </div>
                                                </div>
                                                <div class="px-4 pt-3 pb-2">
                                                    <div class="row">
                                                        <div class="col-6">
                                                            <ul class="list-unstyled mb-0">
                                                                <li class="media mb-2 text-gray-1 align-items-center">
                                                                    <small class="mr-2">
                                                                        <small class="flaticon-plans font-size-16"></small>
                                                                    </small>
                                                                    <div class="media-body font-size-1">
                                                                        4800 sq ft
                                                                    </div>
                                                                </li>
                                                                <li class="media mb-2 text-gray-1 align-items-center">
                                                                    <small class="mr-2">
                                                                        <small class="flaticon-bathtub font-size-16"></small>
                                                                    </small>
                                                                    <div class="media-body font-size-1">
                                                                        2 bathrooms
                                                                    </div>
                                                                </li>
                                                            </ul>
                                                        </div>
                                                        <div class="col-6">
                                                            <ul class="list-unstyled mb-0">
                                                                <li class="media mb-2 text-gray-1 align-items-center">
                                                                    <small class="mr-2">
                                                                        <small class="flaticon-door font-size-16"></small>
                                                                    </small>
                                                                    <div class="media-body font-size-1">
                                                                        4 Rooms
                                                                    </div>
                                                                </li>
                                                                <li class="media mb-2 text-gray-1 align-items-center">
                                                                    <small class="mr-2">
                                                                        <small class="flaticon-bed-1 font-size-16"></small>
                                                                    </small>
                                                                    <div class="media-body font-size-1">
                                                                        6 Beds
                                                                    </div>
                                                                </li>
                                                            </ul>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-6 col-xl-4 mb-3 mb-md-4 pb-1">
                                            <div class="card transition-3d-hover shadow-hover-2">
                                                <div class="position-relative">
                                                    <a href="../rental/rental-single-v2.html" class="d-block gradient-overlay-half-bg-gradient-v5">
                                                        <img class="card-img-top" src="assets/img/300x230/img41.jpg">
                                                    </a>
                                                    <div class="position-absolute top-0 right-0 pt-5 pr-3">
                                                      <button type="button" class="btn btn-sm btn-icon text-white rounded-circle" data-toggle="tooltip" data-placement="top" title="" data-original-title="Save for later">
                                                        <span class="flaticon-heart-1 font-size-20"></span>
                                                      </button>
                                                    </div>
                                                    <div class="position-absolute bottom-0 left-0 right-0">
                                                        <div class="px-3 pb-2">
                                                            <a href="../rental/rental-single-v2.html">
                                                                <span class="text-white font-weight-bold font-size-17"> Office Space in Downey </span>
                                                            </a>
                                                            <div class="text-white my-2">
                                                                <span class="mr-1 font-size-14">From</span>
                                                                <span class="font-weight-bold font-size-19">£350.00</span>
                                                                <span class="mr-1 font-size-14">/ night</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="card-body px-4 py-3 border-bottom">
                                                    <a href="../rental/rental-single-v2.html" class="d-block">
                                                        <div class="d-flex align-items-center font-size-14 text-gray-1">
                                                            <i class="icon flaticon-placeholder mr-2 font-size-20"></i> Istanbul , Turkey
                                                        </div>
                                                    </a>
                                                    <div class="mt-1">
                                                        <span class="py-1 font-size-14 border-radius-3 font-weight-normal pagination-v2-arrow-color">2.5/5 Excellant</span>
                                                        <span class="font-size-14 text-gray-1 ml-2">48 reviews</span>
                                                    </div>
                                                </div>
                                                <div class="px-4 pt-3 pb-2">
                                                    <div class="row">
                                                        <div class="col-6">
                                                            <ul class="list-unstyled mb-0">
                                                                <li class="media mb-2 text-gray-1 align-items-center">
                                                                    <small class="mr-2">
                                                                        <small class="flaticon-plans font-size-16"></small>
                                                                    </small>
                                                                    <div class="media-body font-size-1">
                                                                        4800 sq ft
                                                                    </div>
                                                                </li>
                                                                <li class="media mb-2 text-gray-1 align-items-center">
                                                                    <small class="mr-2">
                                                                        <small class="flaticon-bathtub font-size-16"></small>
                                                                    </small>
                                                                    <div class="media-body font-size-1">
                                                                        2 bathrooms
                                                                    </div>
                                                                </li>
                                                            </ul>
                                                        </div>
                                                        <div class="col-6">
                                                            <ul class="list-unstyled mb-0">
                                                                <li class="media mb-2 text-gray-1 align-items-center">
                                                                    <small class="mr-2">
                                                                        <small class="flaticon-door font-size-16"></small>
                                                                    </small>
                                                                    <div class="media-body font-size-1">
                                                                        4 Rooms
                                                                    </div>
                                                                </li>
                                                                <li class="media mb-2 text-gray-1 align-items-center">
                                                                    <small class="mr-2">
                                                                        <small class="flaticon-bed-1 font-size-16"></small>
                                                                    </small>
                                                                    <div class="media-body font-size-1">
                                                                        6 Beds
                                                                    </div>
                                                                </li>
                                                            </ul>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-6 col-xl-4 mb-3 mb-md-4 pb-1">
                                            <div class="card transition-3d-hover shadow-hover-2">
                                                <div class="position-relative">
                                                    <a href="../rental/rental-single-v2.html" class="d-block gradient-overlay-half-bg-gradient-v5">
                                                        <img class="card-img-top" src="assets/img/300x230/img42.jpg">
                                                    </a>
                                                    <div class="position-absolute top-0 right-0 pt-5 pr-3">
                                                      <button type="button" class="btn btn-sm btn-icon text-white rounded-circle" data-toggle="tooltip" data-placement="top" title="" data-original-title="Save for later">
                                                        <span class="flaticon-heart-1 font-size-20"></span>
                                                      </button>
                                                    </div>
                                                    <div class="position-absolute bottom-0 left-0 right-0">
                                                        <div class="px-3 pb-2">
                                                            <a href="../rental/rental-single-v2.html">
                                                                <span class="text-white font-weight-bold font-size-17">Apartment in Wellington</span>
                                                            </a>
                                                            <div class="text-white my-2">
                                                                <span class="mr-1 font-size-14">From</span>
                                                                <span class="font-weight-bold font-size-19">£350.00</span>
                                                                <span class="mr-1 font-size-14">/ night</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="card-body px-4 py-3 border-bottom">
                                                    <a href="../rental/rental-single-v2.html" class="d-block">
                                                        <div class="d-flex align-items-center font-size-14 text-gray-1">
                                                            <i class="icon flaticon-placeholder mr-2 font-size-20"></i> Istanbul , Turkey
                                                        </div>
                                                    </a>
                                                    <div class="mt-1">
                                                        <span class="py-1 font-size-14 border-radius-3 font-weight-normal pagination-v2-arrow-color">2.5/5 Excellant</span>
                                                        <span class="font-size-14 text-gray-1 ml-2">48 reviews</span>
                                                    </div>
                                                </div>
                                                <div class="px-4 pt-3 pb-2">
                                                    <div class="row">
                                                        <div class="col-6">
                                                            <ul class="list-unstyled mb-0">
                                                                <li class="media mb-2 text-gray-1 align-items-center">
                                                                    <small class="mr-2">
                                                                        <small class="flaticon-plans font-size-16"></small>
                                                                    </small>
                                                                    <div class="media-body font-size-1">
                                                                        4800 sq ft
                                                                    </div>
                                                                </li>
                                                                <li class="media mb-2 text-gray-1 align-items-center">
                                                                    <small class="mr-2">
                                                                        <small class="flaticon-bathtub font-size-16"></small>
                                                                    </small>
                                                                    <div class="media-body font-size-1">
                                                                        2 bathrooms
                                                                    </div>
                                                                </li>
                                                            </ul>
                                                        </div>
                                                        <div class="col-6">
                                                            <ul class="list-unstyled mb-0">
                                                                <li class="media mb-2 text-gray-1 align-items-center">
                                                                    <small class="mr-2">
                                                                        <small class="flaticon-door font-size-16"></small>
                                                                    </small>
                                                                    <div class="media-body font-size-1">
                                                                        4 Rooms
                                                                    </div>
                                                                </li>
                                                                <li class="media mb-2 text-gray-1 align-items-center">
                                                                    <small class="mr-2">
                                                                        <small class="flaticon-bed-1 font-size-16"></small>
                                                                    </small>
                                                                    <div class="media-body font-size-1">
                                                                        6 Beds
                                                                    </div>
                                                                </li>
                                                            </ul>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>-->
                                </div>
                            </div>
                            <!-- End Tab Content -->
                        </div>
                        {{#with this.[0]}}
                        <div class="text-center text-md-left font-size-14 mb-3 text-lh-1">Showing {{minus (multiple currentPage pageSize) (minus pageSize 1)}}–{{multiple pageSize currentPage}}</div>
                                    <nav aria-label="Page navigation">
                                        <ul class="list-pagination-1 pagination border border-color-4 rounded-sm mb-5 mb-lg-0 overflow-auto overflow-xl-visible justify-content-md-center align-items-center py-2">
                                            {{#ifCond previousSize '>' 0}}
                                            <li class="page-item">
                                                <a class="page-link border-right rounded-0 text-gray-5" href="#/wishHotelList/previous" aria-label="Previous">
                                                    <i class="flaticon-left-direction-arrow font-size-10 font-weight-bold"></i>
                                                    <span class="sr-only">Previous</span>
                                                </a>
                                            </li>
                                            {{/ifCond}}
                                            <div id="PageInt" class="" hidden="true"></div>
                                            <div id="OrderInt" class="" hidden="true"></div>
                                            <div id="CategoryOrderInt" class="" hidden="true"></div>
                                            {{#incrementAndRepeat 0 page}}
	                                            <li class="page-item"><a class="page-link font-size-14" href="#/wishHotelList/page/{{plus this 1}}" page={{plus this 1}}>{{plus this 1}}</a></li>
                                            {{/incrementAndRepeat}}
	                                        {{/with}}
                                            
                                           <!-- <li class="page-item"><a class="page-link font-size-14 active" href="#">2</a></li>
                                            <li class="page-item"><a class="page-link font-size-14" href="#">3</a></li>
                                            <li class="page-item"><a class="page-link font-size-14" href="#">4</a></li>
                                            <li class="page-item"><a class="page-link font-size-14" href="#">5</a></li>
                                            <li class="page-item disabled"><a class="page-link font-size-14" href="#">...</a></li>
                                            <li class="page-item"><a class="page-link font-size-14" href="#">66</a></li>
                                            <li class="page-item"><a class="page-link font-size-14" href="#">67</a></li>-->
                                            {{#with this.[0]}}
                                            {{#ifCond nextSize '>' 0}}
                                            <li class="page-item">
                                                <a class="page-link border-left rounded-0 text-gray-5" href="#/wishHotelList/next" aria-label="Next">
                                                    <i class="flaticon-right-thin-chevron font-size-10 font-weight-bold"></i>
                                                    <span class="sr-only">Next</span>
                                                </a>
                                            </li>
                                            {{/ifCond}}
                                            {{/with}}
                                        </ul>
                                    </nav>
                                    </div>
                        <!-- Slick Tab carousel -->
                        </div>
                    </div>
                </div>
            </div>
        `;
	
	let bindTemplate = Handlebars.compile(htmlTemplate);
	let resultTemplate = bindTemplate(responseJsonObject);
	return resultTemplate;
}
