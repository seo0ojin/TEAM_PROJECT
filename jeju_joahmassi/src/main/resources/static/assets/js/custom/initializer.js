function createInitializer() {
	let validator = {};

	const initializer = {

		setValidator: function(v) {
			validator = v;
		}
		,
		getValidator: function() {
			return validator;
		},

		addCustomFunctionHandlebars: function() {
			/*****Handlebars 함수등록 */
			window.Handlebars.registerHelper('select', function(value, options) {
				var $el = $('<select />').html(options.fn(this));
				$el.find('[value="' + value + '"]').attr({ 'selected': 'selected' });
				return $el.html();
			});
			Handlebars.registerHelper('substring', function(str, start, end) {
				return str.substring(start, end);
			});
			Handlebars.registerHelper('intToString', function(i) {
				return i + '';
			});
			Handlebars.registerHelper('toUpper', function(str) {
				return str.toUpperCase();
			});
			Handlebars.registerHelper('starNumber', function(boardStar, star) {
				//assets/img/icon/star-icon2.png
				//"assets/img/icon/star-icon.png"
				if (boardStar >= star) {
					return "assets/img/icon/star-icon2.png";
				} else {
					return "assets/img/icon/star-icon.png"
				}
			});
			Handlebars.registerHelper('ifCond', function(v1, operator, v2, options) {
				switch (operator) {
					case '==':
						return (v1 == v2) ? options.fn(this) : options.inverse(this);
					case '===':
						return (v1 === v2) ? options.fn(this) : options.inverse(this);
					case '!=':
						return (v1 != v2) ? options.fn(this) : options.inverse(this);
					case '!==':
						return (v1 !== v2) ? options.fn(this) : options.inverse(this);
					case '<':
						return (v1 < v2) ? options.fn(this) : options.inverse(this);
					case '<=':
						return (v1 <= v2) ? options.fn(this) : options.inverse(this);
					case '>':
						return (v1 > v2) ? options.fn(this) : options.inverse(this);
					case '>=':
						return (v1 >= v2) ? options.fn(this) : options.inverse(this);
					case '&&':
						return (v1 && v2) ? options.fn(this) : options.inverse(this);
					case '||':
						return (v1 || v2) ? options.fn(this) : options.inverse(this);
					default:
						return options.inverse(this);
				}
			});


			Handlebars.registerHelper('ifEqual', function(arg1, arg2, options) {
				return (arg1 === arg2) ? options.fn(this) : options.inverse(this);
			});

			// Handlebars에 incrementAndRepeat 헬퍼 추가
			Handlebars.registerHelper('incrementAndRepeat', function(start, end, options) {
				let result = '';
				for (let i = start; i <= end; i++) {
					result += options.fn(i);
				}
				return result;
			});

			Handlebars.registerHelper('plus', function(i, i2) {
				return i + i2;
			});

			Handlebars.registerHelper('minus', function(i, i2) {
				return i - i2;
			});

			Handlebars.registerHelper('multiple', function(i, i2) {
				return i * i2;
			});
			
			// Handlebars 헬퍼 함수 정의
			Handlebars.registerHelper('formatNumber', function(number) {
			  // 소수점 이하를 유지하는 코드
			  return parseFloat(number).toFixed(1);
			});
		},
		getMessageScript: function() {
			$.getScript(`js/localization/messages_${navigator.language}.js`);
		},
		validatorSetDefault: function() {
			$.validator.setDefaults({});
		},
		validatorUserWriteFormSetDefault: function() {
			$.validator.setDefaults({
				rules: {
					signupId: {
						required: true,
						remote: {
							url: 'user/idCheck',
							type: 'get',
							data: {
								signupId: function() {
									return $('#signupId').val();
								}
							}
						}
					},

					signupPassword: {
						required: true,
						minlength: 8
					},

					signupPasswordCheck: {
						required: true,
						equalTo: signupPassword
					},

					signupName: {
						required: true,
						minlength: 3
					},

					signupResident: {
						required: true,
						resident: true
					},

					signupEmail: {
						required: true,
						email: true
					},

					signupPhone: {
						required: true,
						phone: true
					}
				},

				messages: {
					signupId: {
						required: '필수 입력 항목입니다.',
						remote: '{0}는 중복된 아이디입니다.'
					},

					signupPassword: {
						required: '필수 입력 항목입니다.',
						minlength: '{0}자 이상 입력하세요.'
					},

					signupPasswordCheck: {
						required: '필수 입력 항목입니다.',
						equalTo: '비밀번호가 일치하지 않습니다.'
					},

					signupName: {
						required: '필수 입력 항목입니다.',
						minlength: '{0}글자 이상 입력하세요.'
					},

					signupResident: {
						required: '필수 입력 항목입니다.',
						resident: '올바른 주민등록번호 형식이 아닙니다.'
					},

					signupEmail: {
						required: '필수 입력 항목입니다.',
						email: '올바른 이메일 형식이 아닙니다.'
					},

					signupPhone: {
						required: '필수 입력 항목입니다.',
						phone: '올바른 핸드폰 형식이 아닙니다.'
					}
				}
			});
		}, validatorUserUpdateFormSetDefault: function() {
			$.validator.setDefaults({
				rules: {
					inputUserPassword: {
						required: false,
						minlength: 8
					},
					
					inputUserPasswordCheck: {
						required: false,
						equalTo: inputUserPassword
					},
					
					inputUserEmail: {
						required: false,
						email: true
					},
					
					inputUserPhone: {
						required: false,
						phone: true
					}
				},
				
				messages: {
					inputUserPassword: {
						minlength: '{0}자 이상 입력하세요.'
					},
					
					inputUserPasswordCheck: {
						equalTo: '비밀번호가 일치하지 않습니다.'
					},
					
					inputUserEmail: {
						email: '올바른 이메일 형식이 아닙니다.'
					},
					
					inputUserPhone: {
						phone: '올바른 핸드폰 형식이 아닙니다.'
					}
				}
			});
		}, 
		
		
		
		
		
		
		/******************************호텔 유효성********************************/
		
		validatorHotelBookingFormSetDefault: function() {
			$.validator.setDefaults({
				rules: {
					inputPhoneHotelBooking: {
						required: true,
						phone: true
					},
					inputNameHotelBooking:{
						required: true
					},
					inputHotelPayBank:{
						required: true,
						creditCard: true
					},
					inputHotelPayMonth:{
						required: true,
						month: true
					},
					inputHotelPayYear:{
						required: true,
						month: true
					}
				},
				messages: {
					inputPhoneHotelBooking: {
						required: '연락처를 입력하세요',
						phone: '휴대폰 형식에 알맞게 입력하세요'
					},
					inputNameHotelBooking:{
						required: '이름을 입력하세요'
					},
					inputHotelPayBank:{
						required: '카드 번호를 입력하세요',
						creditCard: '카드 번호 형식에 알맞게 입력하세요'
					},
					inputHotelPayMonth:{
						required: '월을 입력해 주세요',
						month: '월을 입력해 주세요'
					},
					inputHotelPayYear:{
						required: '연도를 입력해 주세요',
						month: '연도를 입력해 주세요'
					}
				},
				errorClass: 'error'
			});
		}, validatorHotelPaySetDefault: function() {
			$.validator.setDefaults({
				rules: {
					inputHotelPayBank: {
						required: true,
						creditCard: true
					},
				},
				messages: {
					inputHotelPayBank: {
						required: '카드 번호를 입력하세요',
						creditCard: '카드 번호 형식에 알맞게 입력하세요'
					},
				},
				errorClass: 'error'
			});
		}, 
		
		
		
		
		validatorRetaurantBooking1SetDefault: function() {
			$.validator.setDefaults({
				rules: {
					restaurantBooking1Name: {
						required: true
					},

					restaurantBooking1Phone: {
						required: true,
						phone: true
					}
				},
				messages: {
					restaurantBooking1Name: {
						required: '예약자 이름을 입력해주세요'
					},

					restaurantBooking1Phone: {
						required: '예약자 연락처를 입력해주세요',
						phone: '연락처 양식을 지켜서 입력해주세요'
					}
				},
				errorClass: 'error'
			});
		}
	}

	return initializer;
}
export { createInitializer };