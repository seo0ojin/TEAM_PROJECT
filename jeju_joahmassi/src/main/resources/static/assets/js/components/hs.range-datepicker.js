/**
 * Range datepicker wrapper.
 *
 * @author Htmlstream
 * @version 1.0
 *
 */
;(function ($) {
  'use strict';

  $.HSCore.components.HSRangeDatepicker = {
    /**
     *
     *
     * @var Object _baseConfig
     */
    _baseConfig: {},

    /**
     *
     *
     * @var jQuery pageCollection
     */
    pageCollection: $(),

    /**
     * Initialization of Range datepicker wrapper.
     *
     * @param String selector (optional)
     * @param Object config (optional)
     *
     * @return jQuery pageCollection - collection of initialized items.
     */

    init: function (selector, config) {

      this.collection = selector && $(selector).length ? $(selector) : $();
      if (!$(selector).length) return;

      this.config = config && $.isPlainObject(config) ?
        $.extend({}, this._baseConfig, config) : this._baseConfig;

      this.config.itemSelector = selector;

      this.initRangeDatepicker();

      return this.pageCollection;

    },

    initRangeDatepicker: function () {
      //Variables
      var $self = this,
        collection = $self.pageCollection;

      //Actions
      this.collection.each(function (i, el) {
    //Variables
    var $this = $(el),
        optWrapper = $this.data('rp-wrapper'),
        optIsInline = Boolean($this.data('rp-is-inline')),
        optType = $this.data('rp-type'),
        optDateFormat = $this.data('rp-date-format'),
        optDefaultDate = JSON.parse(el.getAttribute('data-rp-default-date')),
        optIsDisableFutureDates = $this.data('rp-is-disable-future-dates'),
        optIsDisableStartDates = $this.data('rp-disable-start-date'), // 수정된 부분
        optIsDisableEndDates = $this.data('rp-disable-end-date'); // 수정된 부분
		console.log(optIsDisableStartDates);
		
	    $this.flatpickr({
	        inline: optIsInline, // boolean
	        mode: optType ? optType : 'single', // 'single', 'multiple', 'range'
	        dateFormat: optDateFormat ? optDateFormat : 'd M Y',
	        defaultDate: optDefaultDate,
	        appendTo: $(optWrapper)[0],
	        numberOfMonths: 2,
	        minDate: 'today',
	        maxDate: optIsDisableFutureDates ? 'today' : false,
	        locale: {
	            firstDayOfWeek: 1,
	            weekdays: {
	                shorthand: ["Su", "Mo", "Tu", "We", "Th", "Fr", "Sa"]
	            },
	            rangeSeparator: ' - '
	        },
	        disable: [
			    function(date) {
					var startDates = [];
					if(optIsDisableStartDates.length > 0){
						startDates = optIsDisableStartDates.split(','); // ,로 구분된 문자열을 배열로 변환
					}
			        var endDates = [];
			        if(optIsDisableEndDates.length > 0){
						endDates = optIsDisableEndDates.split(','); // ,로 구분된 문자열을 배열로 변환
					}
			        for (var i = 0; i < startDates.length; i++) {
			            var startDateStr = startDates[i].replace(/[\[\]]/g, '').trim(); // '['와 ']'를 공백으로 치환
           				var endDateStr = endDates[i].replace(/[\[\]]/g, '').trim(); // '['와 ']'를 공백으로 치환
   						
   						var startDate = new Date(startDateStr); // 문자열 양 끝의 공백 제거 후 변환
			            var endDate = new Date(endDateStr); // 문자열 양 끝의 공백 제거 후 변환
			            if (date >= startDate && date <= endDate) {
							if($('.restaurantTime').length > 0){
								let restaurantNo = $('.restaurantWishBtn').attr('dataNo');
								let send = {
									restaurantNo : restaurantNo,
									rbDate: endDate
								}
								let returnResultJsonObject={};
								$.ajax({
									async:false,
									method: 'POST',
									url: 'restaurantBooking/timeCheck2',
									contentType: 'application/json;UTF-8',
									data: JSON.stringify(send),
									type: 'json',
									success: function(resultJsonObject) {
										returnResultJsonObject = resultJsonObject;
									}
								});
								if(returnResultJsonObject.length >= 14){
									return true; // 비활성화
								}
							}else{
								return true; // 비활성화
							}
			            }
			        }
			        return false; // 활성화
			    }
			],
			onChange: function(selectedDates, dateStr, instance) {
		        // selectedDates에 선택한 날짜가 배열로 전달됩니다.
		        // 여기에서 필요한 작업을 수행합니다.
		        
		        if($('.restaurantTime').length > 0){
					// 초기 드랍다운 아이템으로 복원
			        $('.dropdown-item.restaurantTime').show();
					
					let restaurantNo = $('.restaurantWishBtn').attr('dataNo');
					let send = {
						restaurantNo : restaurantNo,
						rbDate: selectedDates[0].toISOString().split('T')[0]
					}
					let returnResultJsonObject={};	
					$.ajax({
						async:false,
						method: 'POST',
						url: 'restaurantBooking/timeCheck',
						contentType: 'application/json;UTF-8',
						data: JSON.stringify(send),
						type: 'json',
						success: function(resultJsonObject) {
							returnResultJsonObject = resultJsonObject;
						}
					});
					console.log(returnResultJsonObject);
					returnResultJsonObject.forEach(function(time) {
			            $('.restaurantTime:contains("' + time + '")').hide();
			        });
				}
		    }
	    });
	
	    $this.css({
	        width: $this.val().length * 7.5
	    });
	
		    //Actions
		    collection = collection.add($this);
		});
    }
  };
})(jQuery);
