export function attractionList_form(responseJsonObject = {}) {
	let htmltemplate = 
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
                            <h3 class="font-size-21 font-weight-bold mb-0 text-lh-1">{{this.[0].attractionSize}}개의 명소</h3>
                            <!--<ul class="nav tab-nav-shop flex-nowrap" id="pills-tab" role="tablist">
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
                            <div class="mb-5">
                                <ul class="nav flex-nowrap border border-radius-3 tab-nav align-items-center py-2 px-0" role="tablist">
									<li class="nav-item d-flex align-items-center flex-shrink-0 flex-xl-shrink-1 border-left">
										<a id="Stars" class="nav-link font-weight-normal text-gray-1 text-lh-1dot6 py-1 px-4 px-wd-5 font-weight-normal font-size-15 ">별점 높은순
                                        </a>
										<!--
                                        <select class="js-select selectpicker dropdown-select bootstrap-select__custom-nav w-auto" data-style="btn-sm py-1 px-4 px-wd-5 font-weight-normal font-size-15  text-gray-1 d-flex align-items-center">
                                          <option value="one" selected>Stars</option>
                                          <option value="two">Two</option>
                                          <option value="three">Three</option>
                                          <option value="four">Four</option>
                                        </select>
                                        -->
                                    </li>
                                    <li class="nav-item d-flex align-items-center flex-shrink-0 flex-xl-shrink-1 border-left">
                                        <a id="TopReview" class="nav-link font-weight-normal text-gray-1 text-lh-1dot6 py-1 px-4 px-wd-5 font-weight-normal font-size-15 ">리뷰 많은순
                                        </a>
                                    </li>
									<!--
                                    <li class="nav-item d-flex align-items-center flex-shrink-0 flex-xl-shrink-1">
                                        <a href="#" class="nav-link font-weight-normal text-gray-1 text-lh-1dot6 py-1 px-4 px-wd-5 font-weight-normal font-size-15 ">Recommended
                                        </a>
                                    </li>
                                    -->
                                    <!--
                                    <li class="nav-item d-flex align-items-center flex-shrink-0 flex-xl-shrink-1 border-left">
                                        <select class="js-select selectpicker dropdown-select bootstrap-select__custom-nav w-auto" data-style="btn-sm py-1 px-4 px-wd-5 font-weight-normal font-size-15  text-gray-1 d-flex align-items-center">
                                          <option value="one" selected>Price</option>
                                          <option value="two">Two</option>
                                          <option value="three">Three</option>
                                          <option value="four">Four</option>
                                        </select>
                                    </li>
                                    -->
                                    <!--
                                    <li class="nav-item d-flex align-items-center flex-shrink-0 flex-xl-shrink-1 border-left">
                                        <a href="#" class="nav-link font-weight-normal text-gray-1 text-lh-1dot6 py-1 px-4 px-wd-5 font-weight-normal font-size-15 ">Guest Rating
                                        </a>
                                    </li>
                                    -->
                                    <!--
                                    <li class="nav-item d-flex align-items-center flex-shrink-0 flex-xl-shrink-1 border-left">
                                        <a href="#" class="nav-link font-weight-normal text-gray-1 text-lh-1dot6 py-1 px-4 px-wd-5 font-weight-normal font-size-15 ">Distance
                                        </a>
                                    </li>
                                    -->
                                </ul>
                            </div>
                            <!-- End Nav Links -->

                            <!-- Tab Content -->
                            <div class="tab-content" id="pills-tabContent">
                                <div class="tab-pane fade" id="pills-three-example1" role="tabpanel" aria-labelledby="pills-three-example1-tab" data-target-group="groups">
                                    <ul class="d-block list-unstyled products-group prodcut-list-view">
                                        <li class="card mb-5 overflow-hidden">
                                            <div class="product-item__outer w-100">
                                                <div class="row">
                                                    <div class="col-md-5 col-xl-4">
                                                        <div class="product-item__header">
                                                            <div class="position-relative">
                                                                <div class="js-slick-carousel u-slick u-slick--equal-height u-slick--gutters-3"
                                                                    data-slides-show="1"
                                                                    data-slides-scroll="1"
                                                                    data-arrows-classes="d-none d-lg-inline-block u-slick__arrow-classic v4 u-slick__arrow-classic--v4 u-slick__arrow-centered--y rounded-circle"
                                                                    data-arrow-left-classes="flaticon-back u-slick__arrow-classic-inner u-slick__arrow-classic-inner--left"
                                                                    data-arrow-right-classes="flaticon-next u-slick__arrow-classic-inner u-slick__arrow-classic-inner--right"
                                                                    data-pagi-classes="js-pagination text-center u-slick__pagination u-slick__pagination--white position-absolute right-0 bottom-0 left-0 mb-3 mb-0">
                                                                    <div class="js-slide">
                                                                        <a href="../tour/tour-single-v1.html" class="d-block gradient-overlay-half-bg-gradient-v5"><img class="img-fluid min-height-230" src="assets/img/300x230/img1.jpg"></a>
                                                                    </div>
                                                                    <div class="js-slide">
                                                                        <a href="../tour/tour-single-v1.html" class="d-block gradient-overlay-half-bg-gradient-v5"><img class="img-fluid min-height-230" src="assets/img/300x230/img2.jpg"></a>
                                                                    </div>
                                                                    <div class="js-slide">
                                                                        <a href="../tour/tour-single-v1.html" class="d-block gradient-overlay-half-bg-gradient-v5"><img class="img-fluid min-height-230" src="assets/img/300x230/img3.jpg"></a>
                                                                    </div>
                                                                    <div class="js-slide">
                                                                        <a href="../tour/tour-single-v1.html" class="d-block gradient-overlay-half-bg-gradient-v5"><img class="img-fluid min-height-230" src="assets/img/300x230/img4.jpg"></a>
                                                                    </div>
                                                                    <div class="js-slide">
                                                                        <a href="../tour/tour-single-v1.html" class="d-block gradient-overlay-half-bg-gradient-v5"><img class="img-fluid min-height-230" src="assets/img/300x230/img5.jpg"></a>
                                                                    </div>
                                                                    <div class="js-slide">
                                                                        <a href="../tour/tour-single-v1.html" class="d-block gradient-overlay-half-bg-gradient-v5"><img class="img-fluid min-height-230" src="assets/img/300x230/img6.jpg"></a>
                                                                    </div>
                                                                </div>

                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-7 col-xl-5 flex-horizontal-center">
                                                        <div class="w-100 position-relative m-4 m-md-0">
                                                            <div class="mb-2 pb-1">
                                                                <span class="badge badge-pill bg-blue-1 text-white px-4 py-1 font-size-14 font-weight-normal text-lh-1dot6 mb-1">Featured</span>
                                                                <span class="badge badge-pill bg-pink-1 text-white px-3 py-1 font-size-14 font-weight-normal text-lh-1dot6 mb-1 ml-2">%25</span>
                                                                <span class="green-lighter ml-md-2 d-block d-md-inline">
                                                                    <small class="fas fa-star font-size-11"></small>
                                                                    <small class="fas fa-star font-size-11"></small>
                                                                    <small class="fas fa-star font-size-11"></small>
                                                                    <small class="fas fa-star font-size-11"></small>
                                                                    <small class="fas fa-star font-size-11"></small>
                                                                </span>
                                                            </div>

                                                            <div class="position-absolute top-0 right-0 pr-md-3 d-none d-md-block">
                                                                <button type="button" class="btn btn-sm btn-icon rounded-circle" data-toggle="tooltip" data-placement="top" title="" data-original-title="Save for later">
                                                                    <span class="flaticon-heart-1 font-size-20"></span>
                                                                </button>
                                                            </div>
                                                            <a href="../tour/tour-single-v1.html">
                                                                <span class="font-weight-bold font-size-17 text-dark d-flex mb-1">Stonehenge, Windsor Castle, and Bath from London</span>
                                                            </a>
                                                            <div class="card-body p-0">
                                                                <a href="../tour/tour-single-v1.html" class="d-block mb-3">
                                                                    <div class="d-flex flex-wrap flex-xl-nowrap align-items-center font-size-14 text-gray-1">
                                                                        <i class="icon flaticon-placeholder mr-2 font-size-20"></i> Greater London, United Kingdom
                                                                        <small class="px-1 font-size-15"> - </small>
                                                                        <span class="text-primary font-size-14">View on map</span>
                                                                    </div>
                                                                </a>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    
                                                    <div class="col col-xl-3 align-self-center py-4 py-xl-0 border-top border-xl-top-0">
                                                        <div class="border-xl-left border-color-7">
                                                            <div class="ml-md-4 ml-xl-0">
                                                                <div class="text-center text-md-left text-xl-center d-flex flex-column mb-2 pb-1 ml-md-3 ml-xl-0">
                                                                    <div class="d-flex flex-column mb-2">
                                                                        <span class="font-weight-normal font-size-14 text-gray-1 mb-2 pb-1 ml-md-2 ml-xl-0">Multi-day Tours</span>
                                                                        <span class="font-weight-normal font-size-14 text-gray-1">3 hours 45 minutes</span>
                                                                    </div>
                                                                    <div class="mb-0">
                                                                        <span class="mr-1 font-size-14 text-gray-1">From</span>
                                                                        <span class="font-weight-bold font-size-22">£350.00</span>
                                                                    </div>
                                                                </div>
                                                                <div class="d-flex justify-content-center justify-content-md-start justify-content-xl-center">
                                                                    <a href="../tour/tour-single-v1.html" class="btn btn-outline-primary d-flex align-items-center justify-content-center font-weight-bold min-height-50 border-radius-3 border-width-2 px-2 px-5 py-2">View Detail</a>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </li>
                                        <li class="card mb-5 overflow-hidden">
                                            <div class="product-item__outer w-100">
                                                <div class="row">
                                                    <div class="col-md-5 col-xl-4">
                                                        <div class="product-item__header">
                                                            <div class="position-relative">
                                                                <div class="js-slick-carousel u-slick u-slick--equal-height u-slick--gutters-3"
                                                                    data-slides-show="1"
                                                                    data-slides-scroll="1"
                                                                    data-arrows-classes="d-none d-lg-inline-block u-slick__arrow-classic v4 u-slick__arrow-classic--v4 u-slick__arrow-centered--y rounded-circle"
                                                                    data-arrow-left-classes="flaticon-back u-slick__arrow-classic-inner u-slick__arrow-classic-inner--left"
                                                                    data-arrow-right-classes="flaticon-next u-slick__arrow-classic-inner u-slick__arrow-classic-inner--right"
                                                                    data-pagi-classes="js-pagination text-center u-slick__pagination u-slick__pagination--white position-absolute right-0 bottom-0 left-0 mb-3 mb-0">
                                                                    <div class="js-slide">
                                                                        <a href="../tour/tour-single-v2.html" class="d-block gradient-overlay-half-bg-gradient-v5"><img class="img-fluid min-height-230" src="assets/img/300x230/img2.jpg"></a>
                                                                    </div>
                                                                    <div class="js-slide">
                                                                        <a href="../tour/tour-single-v2.html" class="d-block gradient-overlay-half-bg-gradient-v5"><img class="img-fluid min-height-230" src="assets/img/300x230/img48.jpg"></a>
                                                                    </div>
                                                                    <div class="js-slide">
                                                                        <a href="../tour/tour-single-v2.html" class="d-block gradient-overlay-half-bg-gradient-v5"><img class="img-fluid min-height-230" src="assets/img/300x230/img4.jpg"></a>
                                                                    </div>
                                                                    <div class="js-slide">
                                                                        <a href="../tour/tour-single-v2.html" class="d-block gradient-overlay-half-bg-gradient-v5"><img class="img-fluid min-height-230" src="assets/img/300x230/img49.jpg"></a>
                                                                    </div>
                                                                    <div class="js-slide">
                                                                        <a href="../tour/tour-single-v2.html" class="d-block gradient-overlay-half-bg-gradient-v5"><img class="img-fluid min-height-230" src="assets/img/300x230/img50.jpg"></a>
                                                                    </div>
                                                                    <div class="js-slide">
                                                                        <a href="../tour/tour-single-v2.html" class="d-block gradient-overlay-half-bg-gradient-v5"><img class="img-fluid min-height-230" src="assets/img/300x230/img51.jpg"></a>
                                                                    </div>
                                                                </div>

                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-7 col-xl-5 flex-horizontal-center">
                                                        <div class="w-100 position-relative m-4 m-md-0">
                                                            <div class="mb-2 pb-1">
                                                                <span class="badge badge-pill bg-blue-1 text-white px-4 py-1 font-size-14 font-weight-normal text-lh-1dot6 mb-1">Featured</span>
                                                                <span class="badge badge-pill bg-pink-1 text-white px-3 py-1 font-size-14 font-weight-normal text-lh-1dot6 mb-1 ml-2">%25</span>
                                                                <span class="green-lighter ml-md-2 d-block d-md-inline">
                                                                    <small class="fas fa-star font-size-11"></small>
                                                                    <small class="fas fa-star font-size-11"></small>
                                                                    <small class="fas fa-star font-size-11"></small>
                                                                    <small class="fas fa-star font-size-11"></small>
                                                                    <small class="fas fa-star font-size-11"></small>
                                                                </span>
                                                            </div>

                                                            <div class="position-absolute top-0 right-0 pr-md-3 d-none d-md-block">
                                                                <button type="button" class="btn btn-sm btn-icon rounded-circle" data-toggle="tooltip" data-placement="top" title="" data-original-title="Save for later">
                                                                    <span class="flaticon-heart-1 font-size-20"></span>
                                                                </button>
                                                            </div>
                                                            <a href="../tour/tour-single-v2.html">
                                                                <span class="font-weight-bold font-size-17 text-dark d-flex mb-1">Bosphorus Strait and Black Sea Half-Day Cruise from Istanbul</span>
                                                            </a>
                                                            <div class="card-body p-0">
                                                                <a href="../tour/tour-single-v2.html" class="d-block mb-3">
                                                                    <div class="d-flex flex-wrap flex-xl-nowrap align-items-center font-size-14 text-gray-1">
                                                                        <i class="icon flaticon-placeholder mr-2 font-size-20"></i> Greater London, United Kingdom
                                                                        <small class="px-1 font-size-15"> - </small>
                                                                        <span class="text-primary font-size-14">View on map</span>
                                                                    </div>
                                                                </a>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col col-xl-3 align-self-center py-4 py-xl-0 border-top border-xl-top-0">
                                                        <div class="border-xl-left border-color-7">
                                                            <div class="ml-md-4 ml-xl-0">
                                                                <div class="text-center text-md-left text-xl-center d-flex flex-column mb-2 pb-1 ml-md-3 ml-xl-0">
                                                                    <div class="d-flex flex-column mb-2">
                                                                        <span class="font-weight-normal font-size-14 text-gray-1 mb-2 pb-1 ml-md-2 ml-xl-0">Multi-day Tours</span>
                                                                        <span class="font-weight-normal font-size-14 text-gray-1">3 hours 45 minutes</span>
                                                                    </div>
                                                                    <div class="mb-0">
                                                                        <span class="mr-1 font-size-14 text-gray-1">From</span>
                                                                        <span class="font-weight-bold font-size-22">£350.00</span>
                                                                    </div>
                                                                </div>
                                                                <div class="d-flex justify-content-center justify-content-md-start justify-content-xl-center">
                                                                    <a href="../tour/tour-single-v1.html" class="btn btn-outline-primary d-flex align-items-center justify-content-center font-weight-bold min-height-50 border-radius-3 border-width-2 px-2 px-5 py-2">View Detail</a>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </li>
                                        <li class="card mb-5 overflow-hidden">
                                            <div class="product-item__outer w-100">
                                                <div class="row align-items-center">
                                                    <div class="col-md-5 col-xl-4">
                                                        <div class="product-item__header">
                                                            <div class="position-relative">
                                                                <div class="js-slick-carousel u-slick u-slick--equal-height u-slick--gutters-3"
                                                                    data-slides-show="1"
                                                                    data-slides-scroll="1"
                                                                    data-arrows-classes="d-none d-lg-inline-block u-slick__arrow-classic v4 u-slick__arrow-classic--v4 u-slick__arrow-centered--y rounded-circle"
                                                                    data-arrow-left-classes="flaticon-back u-slick__arrow-classic-inner u-slick__arrow-classic-inner--left"
                                                                    data-arrow-right-classes="flaticon-next u-slick__arrow-classic-inner u-slick__arrow-classic-inner--right"
                                                                    data-pagi-classes="js-pagination text-center u-slick__pagination u-slick__pagination--white position-absolute right-0 bottom-0 left-0 mb-3 mb-0">
                                                                    <div class="js-slide w-100">
                                                                        <a href="../tour/tour-single-v1.html" class="d-block gradient-overlay-half-bg-gradient-v5 w-100"><img class="img-fluid min-height-230" src="assets/img/300x230/img52.jpg"></a>
                                                                    </div>
                                                                    <div class="js-slide w-100">
                                                                        <a href="../tour/tour-single-v1.html" class="d-block gradient-overlay-half-bg-gradient-v5 w-100"><img class="img-fluid min-height-230" src="assets/img/300x230/img51.jpg"></a>
                                                                    </div>
                                                                    <div class="js-slide w-100">
                                                                        <a href="../tour/tour-single-v1.html" class="d-block gradient-overlay-half-bg-gradient-v5 w-100"><img class="img-fluid min-height-230" src="assets/img/300x230/img50.jpg"></a>
                                                                    </div>
                                                                    <div class="js-slide w-100">
                                                                        <a href="../tour/tour-single-v1.html" class="d-block gradient-overlay-half-bg-gradient-v5 w-100"><img class="img-fluid min-height-230" src="assets/img/300x230/img49.jpg"></a>
                                                                    </div>
                                                                    <div class="js-slide w-100">
                                                                        <a href="../tour/tour-single-v1.html" class="d-block gradient-overlay-half-bg-gradient-v5 w-100"><img class="img-fluid min-height-230" src="assets/img/300x230/img48.jpg"></a>
                                                                    </div>
                                                                    <div class="js-slide w-100">
                                                                        <a href="../tour/tour-single-v1.html" class="d-block gradient-overlay-half-bg-gradient-v5 w-100"><img class="img-fluid min-height-230" src="assets/img/300x230/img1.jpg"></a>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-7 col-xl-5 flex-horizontal-center">
                                                        <div class="w-100 position-relative m-4 m-md-0">
                                                            <div class="mb-2 pb-1">
                                                                <span class="badge badge-pill bg-blue-1 text-white px-4 py-1 font-size-14 font-weight-normal text-lh-1dot6 mb-1">Featured</span>
                                                                <span class="badge badge-pill bg-pink-1 text-white px-3 py-1 font-size-14 font-weight-normal text-lh-1dot6 mb-1 ml-2">%25</span>
                                                                <span class="green-lighter ml-md-2 d-block d-md-inline">
                                                                    <small class="fas fa-star font-size-11"></small>
                                                                    <small class="fas fa-star font-size-11"></small>
                                                                    <small class="fas fa-star font-size-11"></small>
                                                                    <small class="fas fa-star font-size-11"></small>
                                                                    <small class="fas fa-star font-size-11"></small>
                                                                </span>
                                                            </div>

                                                            <div class="position-absolute top-0 right-0 pr-md-3 d-none d-md-block">
                                                                <button type="button" class="btn btn-sm btn-icon rounded-circle" data-toggle="tooltip" data-placement="top" title="" data-original-title="Save for later">
                                                                    <span class="flaticon-heart-1 font-size-20"></span>
                                                                </button>
                                                            </div>
                                                            <a href="../tour/tour-single-v1.html">
                                                                <span class="font-weight-bold font-size-17 text-dark d-flex mb-1">Two Capitals Tour of 7 days and 6 nights From Moscow</span>
                                                            </a>
                                                            <div class="card-body p-0">
                                                                <a href="../tour/tour-single-v1.html" class="d-block mb-3">
                                                                    <div class="d-flex flex-wrap flex-xl-nowrap align-items-center font-size-14 text-gray-1">
                                                                        <i class="icon flaticon-placeholder mr-2 font-size-20"></i> Greater London, United Kingdom
                                                                        <small class="px-1 font-size-15"> - </small>
                                                                        <span class="text-primary font-size-14">View on map</span>
                                                                    </div>
                                                                </a>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col col-xl-3 align-self-center py-4 py-xl-0 border-top border-xl-top-0">
                                                        <div class="border-xl-left border-color-7">
                                                            <div class="ml-md-4 ml-xl-0">
                                                                <div class="text-center text-md-left text-xl-center d-flex flex-column mb-2 pb-1 ml-md-3 ml-xl-0">
                                                                    <div class="d-flex flex-column mb-2">
                                                                        <span class="font-weight-normal font-size-14 text-gray-1 mb-2 pb-1 ml-md-2 ml-xl-0">Multi-day Tours</span>
                                                                        <span class="font-weight-normal font-size-14 text-gray-1">3 hours 45 minutes</span>
                                                                    </div>
                                                                    <div class="mb-0">
                                                                        <span class="mr-1 font-size-14 text-gray-1">From</span>
                                                                        <span class="font-weight-bold font-size-22">£350.00</span>
                                                                    </div>
                                                                </div>
                                                                <div class="d-flex justify-content-center justify-content-md-start justify-content-xl-center">
                                                                    <a href="../tour/tour-single-v1.html" class="btn btn-outline-primary d-flex align-items-center justify-content-center font-weight-bold min-height-50 border-radius-3 border-width-2 px-2 px-5 py-2">View Detail</a>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </li>
                                        <li class="card mb-5 overflow-hidden">
                                            <div class="product-item__outer w-100">
                                                <div class="row align-items-center">
                                                    <div class="col-md-5 col-xl-4">
                                                        <div class="product-item__header">
                                                            <div class="position-relative">
                                                                <div class="js-slick-carousel u-slick u-slick--equal-height u-slick--gutters-3"
                                                                    data-slides-show="1"
                                                                    data-slides-scroll="1"
                                                                    data-arrows-classes="d-none d-lg-inline-block u-slick__arrow-classic v4 u-slick__arrow-classic--v4 u-slick__arrow-centered--y rounded-circle"
                                                                    data-arrow-left-classes="flaticon-back u-slick__arrow-classic-inner u-slick__arrow-classic-inner--left"
                                                                    data-arrow-right-classes="flaticon-next u-slick__arrow-classic-inner u-slick__arrow-classic-inner--right"
                                                                    data-pagi-classes="js-pagination text-center u-slick__pagination u-slick__pagination--white position-absolute right-0 bottom-0 left-0 mb-3 mb-0">
                                                                    <div class="js-slide w-100">
                                                                        <a href="../tour/tour-single-v2.html" class="d-block gradient-overlay-half-bg-gradient-v5 w-100"><img class="img-fluid min-height-230" src="assets/img/300x230/img4.jpg"></a>
                                                                    </div>
                                                                    <div class="js-slide w-100">
                                                                        <a href="../tour/tour-single-v2.html" class="d-block gradient-overlay-half-bg-gradient-v5 w-100"><img class="img-fluid min-height-230" src="assets/img/300x230/img5.jpg"></a>
                                                                    </div>
                                                                    <div class="js-slide w-100">
                                                                        <a href="../tour/tour-single-v2.html" class="d-block gradient-overlay-half-bg-gradient-v5 w-100"><img class="img-fluid min-height-230" src="assets/img/300x230/img9.jpg"></a>
                                                                    </div>
                                                                    <div class="js-slide w-100">
                                                                        <a href="../tour/tour-single-v2.html" class="d-block gradient-overlay-half-bg-gradient-v5 w-100"><img class="img-fluid min-height-230" src="assets/img/300x230/img50.jpg"></a>
                                                                    </div>
                                                                    <div class="js-slide w-100">
                                                                        <a href="../tour/tour-single-v2.html" class="d-block gradient-overlay-half-bg-gradient-v5 w-100"><img class="img-fluid min-height-230" src="assets/img/300x230/img49.jpg"></a>
                                                                    </div>
                                                                    <div class="js-slide w-100">
                                                                        <a href="../tour/tour-single-v2.html" class="d-block gradient-overlay-half-bg-gradient-v5 w-100"><img class="img-fluid min-height-230" src="assets/img/300x230/img3.jpg"></a>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-7 col-xl-5 flex-horizontal-center">
                                                        <div class="w-100 position-relative m-4 m-md-0">
                                                            <div class="mb-2 pb-1">
                                                                <span class="badge badge-pill bg-blue-1 text-white px-4 py-1 font-size-14 font-weight-normal text-lh-1dot6 mb-1">Featured</span>
                                                                <span class="badge badge-pill bg-pink-1 text-white px-3 py-1 font-size-14 font-weight-normal text-lh-1dot6 mb-1 ml-2">%25</span>
                                                                <span class="green-lighter ml-md-2 d-block d-md-inline">
                                                                    <small class="fas fa-star font-size-11"></small>
                                                                    <small class="fas fa-star font-size-11"></small>
                                                                    <small class="fas fa-star font-size-11"></small>
                                                                    <small class="fas fa-star font-size-11"></small>
                                                                    <small class="fas fa-star font-size-11"></small>
                                                                </span>
                                                            </div>

                                                            <div class="position-absolute top-0 right-0 pr-md-3 d-none d-md-block">
                                                                <button type="button" class="btn btn-sm btn-icon rounded-circle" data-toggle="tooltip" data-placement="top" title="" data-original-title="Save for later">
                                                                    <span class="flaticon-heart-1 font-size-20"></span>
                                                                </button>
                                                            </div>
                                                            <a href="../tour/tour-single-v2.html">
                                                                <span class="font-weight-bold font-size-17 text-dark d-flex mb-1">Two Small-Group Blue Mountains Day Trip from Sydney with River Cruise</span>
                                                            </a>
                                                            <div class="card-body p-0">
                                                                <a href="../tour/tour-single-v2.html" class="d-block mb-3">
                                                                    <div class="d-flex flex-wrap flex-xl-nowrap align-items-center font-size-14 text-gray-1">
                                                                        <i class="icon flaticon-placeholder mr-2 font-size-20"></i> Greater London, United Kingdom
                                                                        <small class="px-1 font-size-15"> - </small>
                                                                        <span class="text-primary font-size-14">View on map</span>
                                                                    </div>
                                                                </a>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col col-xl-3 align-self-center py-4 py-xl-0 border-top border-xl-top-0">
                                                        <div class="border-xl-left border-color-7">
                                                            <div class="ml-md-4 ml-xl-0">
                                                                <div class="text-center text-md-left text-xl-center d-flex flex-column mb-2 pb-1 ml-md-3 ml-xl-0">
                                                                    <div class="d-flex flex-column mb-2">
                                                                        <span class="font-weight-normal font-size-14 text-gray-1 mb-2 pb-1 ml-md-2 ml-xl-0">Multi-day Tours</span>
                                                                        <span class="font-weight-normal font-size-14 text-gray-1">3 hours 45 minutes</span>
                                                                    </div>
                                                                    <div class="mb-0">
                                                                        <span class="mr-1 font-size-14 text-gray-1">From</span>
                                                                        <span class="font-weight-bold font-size-22">£350.00</span>
                                                                    </div>
                                                                </div>
                                                                <div class="d-flex justify-content-center justify-content-md-start justify-content-xl-center">
                                                                    <a href="../tour/tour-single-v1.html" class="btn btn-outline-primary d-flex align-items-center justify-content-center font-weight-bold min-height-50 border-radius-3 border-width-2 px-2 px-5 py-2">View Detail</a>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </li>
                                        <li class="card mb-5 overflow-hidden">
                                            <div class="product-item__outer w-100">
                                                <div class="row align-items-center">
                                                    <div class="col-md-5 col-xl-4">
                                                        <div class="product-item__header">
                                                            <div class="position-relative">
                                                                <div class="js-slick-carousel u-slick u-slick--equal-height u-slick--gutters-3"
                                                                    data-slides-show="1"
                                                                    data-slides-scroll="1"
                                                                    data-arrows-classes="d-none d-lg-inline-block u-slick__arrow-classic v4 u-slick__arrow-classic--v4 u-slick__arrow-centered--y rounded-circle"
                                                                    data-arrow-left-classes="flaticon-back u-slick__arrow-classic-inner u-slick__arrow-classic-inner--left"
                                                                    data-arrow-right-classes="flaticon-next u-slick__arrow-classic-inner u-slick__arrow-classic-inner--right"
                                                                    data-pagi-classes="js-pagination text-center u-slick__pagination u-slick__pagination--white position-absolute right-0 bottom-0 left-0 mb-3 mb-0">
                                                                    <div class="js-slide w-100">
                                                                        <a href="../tour/tour-single-v1.html" class="d-block gradient-overlay-half-bg-gradient-v5 w-100"><img class="img-fluid min-height-230" src="assets/img/300x230/img50.jpg"></a>
                                                                    </div>
                                                                    <div class="js-slide w-100">
                                                                        <a href="../tour/tour-single-v1.html" class="d-block gradient-overlay-half-bg-gradient-v5 w-100"><img class="img-fluid min-height-230" src="assets/img/300x230/img51.jpg"></a>
                                                                    </div>
                                                                    <div class="js-slide w-100">
                                                                        <a href="../tour/tour-single-v1.html" class="d-block gradient-overlay-half-bg-gradient-v5 w-100"><img class="img-fluid min-height-230" src="assets/img/300x230/img60.jpg"></a>
                                                                    </div>
                                                                    <div class="js-slide w-100">
                                                                        <a href="../tour/tour-single-v1.html" class="d-block gradient-overlay-half-bg-gradient-v5 w-100"><img class="img-fluid min-height-230" src="assets/img/300x230/img63.jpg"></a>
                                                                    </div>
                                                                    <div class="js-slide w-100">
                                                                        <a href="../tour/tour-single-v1.html" class="d-block gradient-overlay-half-bg-gradient-v5 w-100"><img class="img-fluid min-height-230" src="assets/img/300x230/img48.jpg"></a>
                                                                    </div>
                                                                    <div class="js-slide w-100">
                                                                        <a href="../tour/tour-single-v1.html" class="d-block gradient-overlay-half-bg-gradient-v5 w-100"><img class="img-fluid min-height-230" src="assets/img/300x230/img5.jpg"></a>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-7 col-xl-5 flex-horizontal-center">
                                                        <div class="w-100 position-relative m-4 m-md-0">
                                                            <div class="mb-2 pb-1">
                                                                <span class="badge badge-pill bg-blue-1 text-white px-4 py-1 font-size-14 font-weight-normal text-lh-1dot6 mb-1">Featured</span>
                                                                <span class="badge badge-pill bg-pink-1 text-white px-3 py-1 font-size-14 font-weight-normal text-lh-1dot6 mb-1 ml-2">%25</span>
                                                                <span class="green-lighter ml-md-2 d-block d-md-inline">
                                                                    <small class="fas fa-star font-size-11"></small>
                                                                    <small class="fas fa-star font-size-11"></small>
                                                                    <small class="fas fa-star font-size-11"></small>
                                                                    <small class="fas fa-star font-size-11"></small>
                                                                    <small class="fas fa-star font-size-11"></small>
                                                                </span>
                                                            </div>

                                                            <div class="position-absolute top-0 right-0 pr-md-3 d-none d-md-block">
                                                                <button type="button" class="btn btn-sm btn-icon rounded-circle" data-toggle="tooltip" data-placement="top" title="" data-original-title="Save for later">
                                                                    <span class="flaticon-heart-1 font-size-20"></span>
                                                                </button>
                                                            </div>
                                                            <a href="../tour/tour-single-v1.html">
                                                                <span class="font-weight-bold font-size-17 text-dark d-flex mb-1">Bosphorus Strait and Black Sea Half-Day Cruise from Istanbul</span>
                                                            </a>
                                                            <div class="card-body p-0">
                                                                <a href="../tour/tour-single-v1.html" class="d-block mb-3">
                                                                    <div class="d-flex flex-wrap flex-xl-nowrap align-items-center font-size-14 text-gray-1">
                                                                        <i class="icon flaticon-placeholder mr-2 font-size-20"></i> Greater London, United Kingdom
                                                                        <small class="px-1 font-size-15"> - </small>
                                                                        <span class="text-primary font-size-14">View on map</span>
                                                                    </div>
                                                                </a>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col col-xl-3 align-self-center py-4 py-xl-0 border-top border-xl-top-0">
                                                        <div class="border-xl-left border-color-7">
                                                            <div class="ml-md-4 ml-xl-0">
                                                                <div class="text-center text-md-left text-xl-center d-flex flex-column mb-2 pb-1 ml-md-3 ml-xl-0">
                                                                    <div class="d-flex flex-column mb-2">
                                                                        <span class="font-weight-normal font-size-14 text-gray-1 mb-2 pb-1 ml-md-2 ml-xl-0">Multi-day Tours</span>
                                                                        <span class="font-weight-normal font-size-14 text-gray-1">3 hours 45 minutes</span>
                                                                    </div>
                                                                    <div class="mb-0">
                                                                        <span class="mr-1 font-size-14 text-gray-1">From</span>
                                                                        <span class="font-weight-bold font-size-22">£350.00</span>
                                                                    </div>
                                                                </div>
                                                                <div class="d-flex justify-content-center justify-content-md-start justify-content-xl-center">
                                                                   <a href="../tour/tour-single-v1.html" class="btn btn-outline-primary d-flex align-items-center justify-content-center font-weight-bold min-height-50 border-radius-3 border-width-2 px-2 px-5 py-2">View Detail</a>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </li>
                                    </ul>
                                </div>
                                <div class="tab-pane fade show active" id="pills-one-example1" role="tabpanel" aria-labelledby="pills-one-example1-tab" data-target-group="groups">
                                    <div class="row attraction_wrapper">
										
										
										
										<!-- 명소 시작 -->
                                        {{#ifCond this.[0].attractionNo '>' 0}}
                                        {{#each this}}
                                        <div class="col-md-6 col-xl-4 mb-3 mb-md-4 pb-1">
                                            <div class="card mb-1 transition-3d-hover shadow-hover-2 tab-card h-100">
                                                <div class="position-relative mb-2">
                                                    <a href="attractionDetail?attractionNo={{attractionNo}}" class="d-block gradient-overlay-half-bg-gradient-v5">
                                                        <img class="min-height-230 bg-img-hero card-img-top fixed-size-image" src="assets/img/attractionImage/{{attractionImageDto.[0].imageName}}" alt="img">
                                                    </a>
                                                    <!--
                                                    <div class="position-absolute top-0 left-0 pt-5 pl-3">
                                                        <span class="badge bdge-pill bg-white text-primary px-4 py-2 font-size-14 font-weight-normal">Featured</span>
                                                        <span class="badge badge-pill bg-white text-danger px-3 ml-3 py-2 font-size-14 font-weight-normal">%25</span>
                                                    </div>
                                                    -->
                                                    {{#ifCond session.userNo '!==' null}}
                                                    <div class="position-absolute top-0 right-0 pt-5 pr-3">
                                                      <button type="button" class="btn btn-sm btn-icon text-white rounded-circle" data-toggle="tooltip" data-placement="top" title="" data-original-title="Save for later">
                                                        {{#ifCond wishBool '==' false}}
										                    <span class="wishHeartAttractionInsert flaticon-heart-1 font-size-20" dataNo="{{attractionNo}}"></span>
										                {{else}}
										                    <span class="wishHeartAttractionDelete fi fi-ss-heart font-size-20 text-danger" dataNo="{{attractionNo}}"></span>
										                {{/ifCond}}
                                                      </button>
                                                    </div>
                                                    {{/ifCond}}
                                                    <!--
                                                    <div class="position-absolute bottom-0 left-0 right-0">
                                                        <div class="px-3 pb-2">
                                                            <h2 class="h5 text-white mb-0 font-weight-bold"><small class="mr-2">From</small>£350.00</h2>
                                                        </div>
                                                    </div>
                                                    -->
                                                </div>
                                                <div class="card-body px-4 py-2">
                                                    <a href="../tour/tour-single-v1.html" class="d-block">
                                                        <div class="mb-1 d-flex align-items-center font-size-14 text-gray-1">
                                                            <i class="icon flaticon-pin-1 mr-2 font-size-15">{{attractionAddress}}</i>
                                                        </div>
                                                    </a>
                                                    <a href="../tour/tour-single-v1.html" class="card-title font-size-17 font-weight-bold mb-0 text-dark">{{attractionName}}</a>
                                                    <div class="my-2">
                                                        <div class="d-inline-flex align-items-center font-size-17 text-lh-1 text-primary">
                                                            <div class="green-lighter mr-2">
                                                           		{{#ifCond attractionStar '>' 0 }}
                                                            	{{#incrementAndRepeat 1 attractionStar}}
                                                                <small class="fas fa-star"></small>
                                                                {{/incrementAndRepeat}}
                                                                {{/ifCond}}
                                                                
                                                                {{#incrementAndRepeat (plus attractionStar 1) 5 }}
                                                                <small class="far fa-star"></small>
                                                                {{/incrementAndRepeat}}
                                                                
                                                                <!--<small class="fas fa-star"></small>
                                                                <small class="fas fa-star"></small>
                                                                <small class="fas fa-star"></small>
                                                                <small class="fas fa-star"></small>-->
                                                            </div>
                                                            <span class="text-secondary font-size-14 mt-1">( 리뷰 {{reviewSize}} 개 )</span>
                                                        </div>
                                                    </div>
                                                    <!--
                                                    <div class="mb-1 d-flex align-items-center font-size-14 text-gray-1">
                                                        <i class="icon flaticon-clock-circular-outline mr-2 font-size-14"></i> 3 hours 45 minutes
                                                    </div>
                                                    -->
                                                </div>
                                            </div>
                                        </div>
                                        {{/each}}
                                        {{else}}
                                        {{/ifCond}}
                                        
                                        <!-- 명소 끝 -->
                                        
                                        
                                        
                                        <!--
                                        <div class="col-md-6 col-xl-4 mb-3 mb-md-4 pb-1">
                                            <div class="card mb-1 transition-3d-hover shadow-hover-2 tab-card h-100">
                                                <div class="position-relative mb-2">
                                                    <a href="../tour/tour-single-v2.html" class="d-block gradient-overlay-half-bg-gradient-v5">
                                                        <img class="min-height-230 bg-img-hero card-img-top" src="assets/img/300x230/img2.jpg" alt="img">
                                                    </a>
                                                    <div class="position-absolute top-0 left-0 pt-5 pl-3">
                                                        <span class="badge badge-pill bg-white text-danger px-3 ml-3 py-2 font-size-14 font-weight-normal">%25</span>
                                                    </div>
                                                    <div class="position-absolute top-0 right-0 pt-5 pr-3">
                                                      <button type="button" class="btn btn-sm btn-icon text-white rounded-circle" data-toggle="tooltip" data-placement="top" title="" data-original-title="Save for later">
                                                        <span class="flaticon-valentine-heart font-size-20"></span>
                                                      </button>
                                                    </div>
                                                    <div class="position-absolute bottom-0 left-0 right-0">
                                                        <div class="px-3 pb-2">
                                                            <span class="text-gray-10 font-weight-normal font-size-14">Multi-day Tours</span>
                                                            <h2 class="h5 text-white mb-0 font-weight-bold"><small class="mr-2">From</small>£899.00</h2>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="card-body px-4 py-2">
                                                    <a href="../tour/tour-single-v2.html" class="d-block">
                                                        <div class="mb-1 d-flex align-items-center font-size-14 text-gray-1">
                                                            <i class="icon flaticon-pin-1 mr-2 font-size-15"></i> Istanbul, Turkey
                                                        </div>
                                                    </a>
                                                    <a href="../tour/tour-single-v2.html" class="card-title text-dark font-size-17 font-weight-bold">Bosphorus Strait and Black Sea Half-Day Cruise from Istanbul</a>
                                                    <div class="my-2">
                                                        <div class="d-inline-flex align-items-center font-size-17 text-lh-1">
                                                            <div class="green-lighter mr-2">
                                                                <small class="fas fa-star"></small>
                                                                <small class="fas fa-star"></small>
                                                                <small class="fas fa-star"></small>
                                                                <small class="fas fa-star"></small>
                                                                <small class="fas fa-star"></small>
                                                            </div>
                                                            <span class="text-secondary font-size-14 mt-1">48 Reviews</span>
                                                        </div>
                                                    </div>
                                                    <div class="mb-1 d-flex align-items-center font-size-14 text-gray-1">
                                                        <i class="icon flaticon-clock-circular-outline mr-2 font-size-14"></i> 3 hours 45 minutes
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-6 col-xl-4 mb-3 mb-md-4 pb-1">
                                            <div class="card mb-1 transition-3d-hover shadow-hover-2 tab-card h-100">
                                                <div class="position-relative mb-2">
                                                    <a href="../tour/tour-single-v1.html" class="d-block gradient-overlay-half-bg-gradient-v5">
                                                        <img class="min-height-230 bg-img-hero card-img-top" src="assets/img/300x230/img3.jpg" alt="img">
                                                    </a>
                                                    <div class="position-absolute top-0 right-0 pt-5 pr-3">
                                                      <button type="button" class="btn btn-sm btn-icon text-white rounded-circle" data-toggle="tooltip" data-placement="top" title="" data-original-title="Save for later">
                                                        <span class="flaticon-valentine-heart font-size-20"></span>
                                                      </button>
                                                    </div>
                                                    <div class="position-absolute bottom-0 left-0 right-0">
                                                        <div class="px-3 pb-2">
                                                            <span class="text-gray-10 font-weight-normal font-size-14">Attraction Tickets</span>
                                                            <h2 class="h5 text-white mb-0 font-weight-bold"><small class="mr-2">From</small>£590.00</h2>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="card-body px-4 py-2">
                                                    <a href="../tour/tour-single-v1.html" class="d-block">
                                                        <div class="mb-1 d-flex align-items-center font-size-14 text-gray-1">
                                                            <i class="icon flaticon-pin-1 mr-2 font-size-15"></i> Istanbul, Turkey
                                                        </div>
                                                    </a>
                                                    <a href="../tour/tour-single-v1.html" class="card-title text-dark font-size-17 font-weight-bold">NYC One World Observatory Skip-the-Line Ticket</a>
                                                    <div class="my-2">
                                                        <div class="d-inline-flex align-items-center font-size-17 text-lh-1">
                                                            <div class="green-lighter mr-2">
                                                                <small class="fas fa-star"></small>
                                                                <small class="fas fa-star"></small>
                                                                <small class="fas fa-star"></small>
                                                                <small class="fas fa-star"></small>
                                                                <small class="fas fa-star"></small>
                                                            </div>
                                                            <span class="text-secondary font-size-14 mt-1">48 Reviews</span>
                                                        </div>
                                                    </div>
                                                    <div class="mb-1 d-flex align-items-center font-size-14 text-gray-1">
                                                        <i class="icon flaticon-clock-circular-outline mr-2 font-size-14"></i> 3 hours 45 minutes
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-6 col-xl-4 mb-3 mb-md-4 pb-1">
                                            <div class="card mb-1 transition-3d-hover shadow-hover-2 tab-card h-100">
                                                <div class="position-relative mb-2">
                                                    <a href="../tour/tour-single-v1.html" class="d-block gradient-overlay-half-bg-gradient-v5">
                                                        <img class="min-height-230 bg-img-hero card-img-top" src="assets/img/300x230/img4.jpg" alt="img">
                                                    </a>
                                                    <div class="position-absolute top-0 right-0 pt-5 pr-3">
                                                          <button type="button" class="btn btn-sm btn-icon text-white rounded-circle" data-toggle="tooltip" data-placement="top" title="" data-original-title="Save for later">
                                                            <span class="flaticon-valentine-heart font-size-20"></span>
                                                          </button>
                                                    </div>
                                                    <div class="position-absolute bottom-0 left-0 right-0">
                                                        <div class="px-3 pb-2">
                                                            <span class="text-gray-10 font-weight-normal font-size-14">Culturals Tours</span>
                                                            <h2 class="h5 text-white mb-0 font-weight-bold"><small class="mr-2">From</small>£550.00</h2>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="card-body px-4 py-2">
                                                    <a href="../tour/tour-single-v1.html" class="d-block">
                                                        <div class="mb-1 d-flex align-items-center font-size-14 text-gray-1">
                                                            <i class="icon flaticon-pin-1 mr-2 font-size-15"></i> Istanbul, Turkey
                                                        </div>
                                                    </a>
                                                    <a href="../tour/tour-single-v1.html" class="card-title text-dark font-size-17 font-weight-bold">Small-Group Blue Mountains Day Trip from Sydney with River Cruise</a>
                                                    <div class="my-2">
                                                        <div class="d-inline-flex align-items-center font-size-17 text-lh-1">
                                                            <div class="green-lighter mr-2">
                                                                <small class="fas fa-star"></small>
                                                                <small class="fas fa-star"></small>
                                                                <small class="fas fa-star"></small>
                                                                <small class="fas fa-star"></small>
                                                                <small class="fas fa-star"></small>
                                                            </div>
                                                            <span class="text-secondary font-size-14 mt-1">48 Reviews</span>
                                                        </div>
                                                    </div>
                                                    <div class="mb-1 d-flex align-items-center font-size-14 text-gray-1">
                                                        <i class="icon flaticon-clock-circular-outline mr-2 font-size-14"></i> 3 hours 45 minutes
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-6 col-xl-4 mb-3 mb-md-4 pb-1">
                                            <div class="card mb-1 transition-3d-hover shadow-hover-2 tab-card h-100">
                                                <div class="position-relative mb-2">
                                                    <a href="../tour/tour-single-v2.html" class="d-block gradient-overlay-half-bg-gradient-v5">
                                                        <img class="min-height-230 bg-img-hero card-img-top" src="assets/img/300x230/img48.jpg" alt="img">
                                                    </a>
                                                    <div class="position-absolute top-0 left-0 pt-5 pl-3">
                                                        <span class="badge badge-pill bg-white text-danger px-3 ml-3 py-2 font-size-14 font-weight-normal">%25</span>
                                                    </div>
                                                    <div class="position-absolute top-0 right-0 pt-5 pr-3">
                                                      <button type="button" class="btn btn-sm btn-icon text-white rounded-circle" data-toggle="tooltip" data-placement="top" title="" data-original-title="Save for later">
                                                        <span class="flaticon-valentine-heart font-size-20"></span>
                                                      </button>
                                                    </div>
                                                    <div class="position-absolute bottom-0 left-0 right-0">
                                                        <div class="px-3 pb-2">
                                                            <span class="text-gray-10 font-weight-normal font-size-14">Multi-day Tours</span>
                                                            <h2 class="h5 text-white mb-0 font-weight-bold"><small class="mr-2">From</small>£899.00</h2>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="card-body px-4 py-2">
                                                    <a href="../tour/tour-single-v2.html" class="d-block">
                                                        <div class="mb-1 d-flex align-items-center font-size-14 text-gray-1">
                                                            <i class="icon flaticon-pin-1 mr-2 font-size-15"></i> Istanbul, Turkey
                                                        </div>
                                                    </a>
                                                    <a href="../tour/tour-single-v2.html" class="card-title text-dark font-size-17 font-weight-bold pr-xl-3">Africa – Amazing African Safari</a>
                                                    <div class="my-2">
                                                        <div class="d-inline-flex align-items-center font-size-17 text-lh-1">
                                                            <div class="green-lighter mr-2">
                                                                <small class="fas fa-star"></small>
                                                                <small class="fas fa-star"></small>
                                                                <small class="fas fa-star"></small>
                                                                <small class="fas fa-star"></small>
                                                                <small class="fas fa-star"></small>
                                                            </div>
                                                            <span class="text-secondary font-size-14 mt-1">48 Reviews</span>
                                                        </div>
                                                    </div>
                                                    <div class="mb-1 d-flex align-items-center font-size-14 text-gray-1">
                                                        <i class="icon flaticon-clock-circular-outline mr-2 font-size-14"></i> 3 hours 45 minutes
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-6 col-xl-4 mb-3 mb-md-4 pb-1">
                                            <div class="card mb-1 transition-3d-hover shadow-hover-2 tab-card h-100">
                                                <div class="position-relative mb-2">
                                                    <a href="../tour/tour-single-v1.html" class="d-block gradient-overlay-half-bg-gradient-v5">
                                                        <img class="min-height-230 bg-img-hero card-img-top" src="assets/img/300x230/img49.jpg" alt="img">
                                                    </a>
                                                    <div class="position-absolute top-0 right-0 pt-5 pr-3">
                                                      <button type="button" class="btn btn-sm btn-icon text-white rounded-circle" data-toggle="tooltip" data-placement="top" title="" data-original-title="Save for later">
                                                        <span class="flaticon-valentine-heart font-size-20"></span>
                                                      </button>
                                                    </div>
                                                    <div class="position-absolute bottom-0 left-0 right-0">
                                                        <div class="px-3 pb-2">
                                                            <span class="text-gray-10 font-weight-normal font-size-14">Attraction Tickets</span>
                                                            <h2 class="h5 text-white mb-0 font-weight-bold"><small class="mr-2">From</small>£590.00</h2>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="card-body px-4 py-2">
                                                    <a href="../tour/tour-single-v1.html" class="d-block">
                                                        <div class="mb-1 d-flex align-items-center font-size-14 text-gray-1">
                                                            <i class="icon flaticon-pin-1 mr-2 font-size-15"></i> Istanbul, Turkey
                                                        </div>
                                                    </a>
                                                    <a href="../tour/tour-single-v1.html" class="card-title text-dark font-size-17 font-weight-bold">Enquiry Form Only  <br> Paris – 6 Days</a>
                                                    <div class="my-2">
                                                        <div class="d-inline-flex align-items-center font-size-17 text-lh-1">
                                                            <div class="green-lighter mr-2">
                                                                <small class="fas fa-star"></small>
                                                                <small class="fas fa-star"></small>
                                                                <small class="fas fa-star"></small>
                                                                <small class="fas fa-star"></small>
                                                                <small class="fas fa-star"></small>
                                                            </div>
                                                            <span class="text-secondary font-size-14 mt-1">48 Reviews</span>
                                                        </div>
                                                    </div>
                                                    <div class="mb-1 d-flex align-items-center font-size-14 text-gray-1">
                                                        <i class="icon flaticon-clock-circular-outline mr-2 font-size-14"></i> 3 hours 45 minutes
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-6 col-xl-4 mb-3 mb-md-4 pb-1">
                                            <div class="card mb-1 transition-3d-hover shadow-hover-2 tab-card h-100">
                                                <div class="position-relative mb-2">
                                                    <a href="../tour/tour-single-v2.html" class="d-block gradient-overlay-half-bg-gradient-v5">
                                                        <img class="min-height-230 bg-img-hero card-img-top" src="assets/img/300x230/img50.jpg" alt="img">
                                                    </a>
                                                    <div class="position-absolute top-0 right-0 pt-5 pr-3">
                                                          <button type="button" class="btn btn-sm btn-icon text-white rounded-circle" data-toggle="tooltip" data-placement="top" title="" data-original-title="Save for later">
                                                            <span class="flaticon-valentine-heart font-size-20"></span>
                                                          </button>
                                                    </div>
                                                    <div class="position-absolute bottom-0 left-0 right-0">
                                                        <div class="px-3 pb-2">
                                                            <span class="text-gray-10 font-weight-normal font-size-14">Culturals Tours</span>
                                                            <h2 class="h5 text-white mb-0 font-weight-bold"><small class="mr-2">From</small>£550.00</h2>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="card-body px-4 py-2">
                                                    <a href="../tour/tour-single-v2.html" class="d-block">
                                                        <div class="mb-1 d-flex align-items-center font-size-14 text-gray-1">
                                                            <i class="icon flaticon-pin-1 mr-2 font-size-15"></i> Istanbul, Turkey
                                                        </div>
                                                    </a>
                                                    <a href="../tour/tour-single-v2.html" class="card-title text-dark font-size-17 font-weight-bold pr-xl-3">Venice, Rome and Milan – <br> 9 Days 8 Nights</a>
                                                    <div class="my-2">
                                                        <div class="d-inline-flex align-items-center font-size-17 text-lh-1">
                                                            <div class="green-lighter mr-2">
                                                                <small class="fas fa-star"></small>
                                                                <small class="fas fa-star"></small>
                                                                <small class="fas fa-star"></small>
                                                                <small class="fas fa-star"></small>
                                                                <small class="fas fa-star"></small>
                                                            </div>
                                                            <span class="text-secondary font-size-14 mt-1">48 Reviews</span>
                                                        </div>
                                                    </div>
                                                    <div class="mb-1 d-flex align-items-center font-size-14 text-gray-1">
                                                        <i class="icon flaticon-clock-circular-outline mr-2 font-size-14"></i> 3 hours 45 minutes
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-6 col-xl-4 mb-3 mb-md-4 pb-1">
                                            <div class="card mb-1 transition-3d-hover shadow-hover-2 tab-card h-100">
                                                <div class="position-relative mb-2">
                                                    <a href="../tour/tour-single-v1.html" class="d-block gradient-overlay-half-bg-gradient-v5">
                                                        <img class="min-height-230 bg-img-hero card-img-top" src="assets/img/300x230/img51.jpg" alt="img">
                                                    </a>
                                                    <div class="position-absolute top-0 left-0 pt-5 pl-3">
                                                        <span class="badge badge-pill bg-white text-danger px-3 ml-3 py-2 font-size-14 font-weight-normal">%25</span>
                                                    </div>
                                                    <div class="position-absolute top-0 right-0 pt-5 pr-3">
                                                      <button type="button" class="btn btn-sm btn-icon text-white rounded-circle" data-toggle="tooltip" data-placement="top" title="" data-original-title="Save for later">
                                                        <span class="flaticon-valentine-heart font-size-20"></span>
                                                      </button>
                                                    </div>
                                                    <div class="position-absolute bottom-0 left-0 right-0">
                                                        <div class="px-3 pb-2">
                                                            <span class="text-gray-10 font-weight-normal font-size-14">Multi-day Tours</span>
                                                            <h2 class="h5 text-white mb-0 font-weight-bold"><small class="mr-2">From</small>£899.00</h2>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="card-body px-4 py-2">
                                                    <a href="../tour/tour-single-v1.html" class="d-block">
                                                        <div class="mb-1 d-flex align-items-center font-size-14 text-gray-1">
                                                            <i class="icon flaticon-pin-1 mr-2 font-size-15"></i> Istanbul, Turkey
                                                        </div>
                                                    </a>
                                                    <a href="../tour/tour-single-v1.html" class="card-title text-dark font-size-17 font-weight-bold">Molokini and Turtle Arches Snorkeling Trip</a>
                                                    <div class="my-2">
                                                        <div class="d-inline-flex align-items-center font-size-17 text-lh-1">
                                                            <div class="green-lighter mr-2">
                                                                <small class="fas fa-star"></small>
                                                                <small class="fas fa-star"></small>
                                                                <small class="fas fa-star"></small>
                                                                <small class="fas fa-star"></small>
                                                                <small class="fas fa-star"></small>
                                                            </div>
                                                            <span class="text-secondary font-size-14 mt-1">48 Reviews</span>
                                                        </div>
                                                    </div>
                                                    <div class="mb-1 d-flex align-items-center font-size-14 text-gray-1">
                                                        <i class="icon flaticon-clock-circular-outline mr-2 font-size-14"></i> 3 hours 45 minutes
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-6 col-xl-4 mb-3 mb-md-4 pb-1">
                                            <div class="card mb-1 transition-3d-hover shadow-hover-2 tab-card h-100">
                                                <div class="position-relative mb-2">
                                                    <a href="../tour/tour-single-v2.html" class="d-block gradient-overlay-half-bg-gradient-v5">
                                                        <img class="min-height-230 bg-img-hero card-img-top" src="assets/img/300x230/img52.jpg" alt="img">
                                                    </a>
                                                    <div class="position-absolute top-0 right-0 pt-5 pr-3">
                                                      <button type="button" class="btn btn-sm btn-icon text-white rounded-circle" data-toggle="tooltip" data-placement="top" title="" data-original-title="Save for later">
                                                        <span class="flaticon-valentine-heart font-size-20"></span>
                                                      </button>
                                                    </div>
                                                    <div class="position-absolute bottom-0 left-0 right-0">
                                                        <div class="px-3 pb-2">
                                                            <span class="text-gray-10 font-weight-normal font-size-14">Attraction Tickets</span>
                                                            <h2 class="h5 text-white mb-0 font-weight-bold"><small class="mr-2">From</small>£590.00</h2>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="card-body px-4 py-2">
                                                    <a href="../tour/tour-single-v2.html" class="d-block">
                                                        <div class="mb-1 d-flex align-items-center font-size-14 text-gray-1">
                                                            <i class="icon flaticon-pin-1 mr-2 font-size-15"></i> Istanbul, Turkey
                                                        </div>
                                                    </a>
                                                    <a href="../tour/tour-single-v2.html" class="card-title text-dark font-size-17 font-weight-bold">Two Capitals Tour of 7 days and 6 nights From Moscow</a>
                                                    <div class="my-2">
                                                        <div class="d-inline-flex align-items-center font-size-17 text-lh-1">
                                                            <div class="green-lighter mr-2">
                                                                <small class="fas fa-star"></small>
                                                                <small class="fas fa-star"></small>
                                                                <small class="fas fa-star"></small>
                                                                <small class="fas fa-star"></small>
                                                                <small class="fas fa-star"></small>
                                                            </div>
                                                            <span class="text-secondary font-size-14 mt-1">48 Reviews</span>
                                                        </div>
                                                    </div>
                                                    <div class="mb-1 d-flex align-items-center font-size-14 text-gray-1">
                                                        <i class="icon flaticon-clock-circular-outline mr-2 font-size-14"></i> 3 hours 45 minutes
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        -->
                                    </div>
                                </div>
                            </div>
                            <!-- End Tab Content -->
                            {{#with this.[0]}}
                            <div class="text-center text-md-left font-size-14 mb-3 text-lh-1">Showing {{minus (multiple currentPage pageSize) (minus pageSize 1)}}–{{multiple pageSize currentPage}}</div>
                                <nav aria-label="Page navigation">
                                    <ul class="list-pagination-1 pagination border border-color-4 rounded-sm overflow-auto overflow-xl-visible justify-content-md-center align-items-center py-2 mb-0">
                                        {{#ifCond previousSize '>' 0}}
                                        <li class="page-item">
                                            <a class="page-link border-right rounded-0 text-gray-5" href="#/attractionList/page/{{minus currentPage 1}}" aria-label="Previous">
                                                <i class="flaticon-left-direction-arrow font-size-10 font-weight-bold"></i>
                                                <span class="sr-only">Previous</span>
                                            </a>
                                        </li>
                                        {{/ifCond}}
                                        <div id="PageInt" class="" hidden="true"></div>
                                        <div id="OrderInt" class="" hidden="true"></div>
                                        <div id="CategoryOrderInt" class="" hidden="true"></div>
                                        	{{#incrementAndRepeat 0 page}}
                                        		<li class="page-item"><a class="page-link font-size-14" href="#/attractionList/page/{{plus this 1}}" page={{plus this 1}}>{{plus this 1}}</a></li>
                                        	{{/incrementAndRepeat}}
                                        {{/with}}
                                        <!--
                                        <li class="page-item"><a class="page-link font-size-14" href="#">1</a></li>
                                        <li class="page-item"><a class="page-link font-size-14 active" href="#">2</a></li>
                                        <li class="page-item"><a class="page-link font-size-14" href="#">3</a></li>
                                        <li class="page-item"><a class="page-link font-size-14" href="#">4</a></li>
                                        <li class="page-item"><a class="page-link font-size-14" href="#">5</a></li>
                                        <li class="page-item disabled"><a class="page-link font-size-14" href="#">...</a></li>
                                        <li class="page-item"><a class="page-link font-size-14" href="#">66</a></li>
                                        <li class="page-item"><a class="page-link font-size-14" href="#">67</a></li>
                                        -->
                                        {{#with this.[0]}}
                                        {{#ifCond nextSize '>' 0}}
                                        <li class="page-item">
                                            <a class="page-link border-left rounded-0 text-gray-5" href="#/attractionList/page/{{plus currentPage 1}}" aria-label="Next">
                                                <i class="flaticon-right-thin-chevron font-size-10 font-weight-bold"></i>
                                                <span class="sr-only">Next</span>
                                            </a>
                                        </li>
                                        {{/ifCond}}
                                        {{/with}}
                                    </ul>
                                </nav>
                            </div>
                        </div>
                        <!-- Slick Tab carousel -->
                    </div>
                </div>
            </div>
	`;
	
	let bindTemplate = Handlebars.compile(htmltemplate);
	let resultTemplate = bindTemplate(responseJsonObject);
	
	return resultTemplate;
}