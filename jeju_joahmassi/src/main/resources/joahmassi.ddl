DROP TABLE AttractionReview CASCADE CONSTRAINTS;
DROP TABLE HotelQnA CASCADE CONSTRAINTS;
DROP TABLE WIsh CASCADE CONSTRAINTS;
DROP TABLE Coupon CASCADE CONSTRAINTS;
DROP TABLE Attraction CASCADE CONSTRAINTS;
DROP TABLE RestaurantBooking CASCADE CONSTRAINTS;
DROP TABLE RestaurantReview CASCADE CONSTRAINTS;
DROP TABLE RestaurantMenu CASCADE CONSTRAINTS;
DROP TABLE Restaurant CASCADE CONSTRAINTS;
DROP TABLE HotelBooking CASCADE CONSTRAINTS;
DROP TABLE HotelReview CASCADE CONSTRAINTS;
DROP TABLE Hotel CASCADE CONSTRAINTS;
DROP TABLE Userinfo CASCADE CONSTRAINTS;

/**********************************/
/* Table Name: Userinfo */
/**********************************/
CREATE TABLE Userinfo(
		user_no                       		NUMBER(10)		 NULL ,
		user_id                       		VARCHAR2(50)		 NULL ,
		user_password                 		VARCHAR2(50)		 NULL ,
		user_name                     		VARCHAR2(50)		 NULL ,
		user_resident                 		VARCHAR2(50)		 NULL ,
		user_phone                    		VARCHAR2(50)		 NULL ,
		user_point                    		NUMBER(50)		 NULL ,
		user_coupon_year              		NUMBER(10)		 NULL 
);

DROP SEQUENCE Userinfo_user_no_SEQ;

CREATE SEQUENCE Userinfo_user_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

CREATE TRIGGER Userinfo_user_no_TRG
BEFORE INSERT ON Userinfo
FOR EACH ROW
BEGIN
IF :NEW.user_no IS NOT NULL THEN
  SELECT Userinfo_user_no_SEQ.NEXTVAL INTO :NEW.user_no FROM DUAL;
END IF;
END;

COMMENT ON TABLE Userinfo is 'Userinfo';
COMMENT ON COLUMN Userinfo.user_no is 'user_no';
COMMENT ON COLUMN Userinfo.user_id is 'user_id';
COMMENT ON COLUMN Userinfo.user_password is 'user_password';
COMMENT ON COLUMN Userinfo.user_name is 'user_name';
COMMENT ON COLUMN Userinfo.user_resident is 'user_resident';
COMMENT ON COLUMN Userinfo.user_phone is 'user_phone';
COMMENT ON COLUMN Userinfo.user_point is 'user_point';
COMMENT ON COLUMN Userinfo.user_coupon_year is 'user_coupon_year';


/**********************************/
/* Table Name: Hotel */
/**********************************/
CREATE TABLE Hotel(
		hotel_no                      		NUMBER(10)		 NULL ,
		hotel_name                    		VARCHAR2(50)		 NULL ,
		hotel_local                   		VARCHAR2(50)		 NULL ,
		hotel_price                   		INTEGER(100)		 NULL ,
		hotel_star                    		DOUBLE PRECISION		 NULL ,
		hotel_category                		VARCHAR2(50)		 NULL ,
		hotel_desc                    		VARCHAR2(300)		 NULL ,
		hotel_image                   		VARCHAR2(300)		 NULL 
);

DROP SEQUENCE Hotel_hotel_no_SEQ;

CREATE SEQUENCE Hotel_hotel_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

CREATE TRIGGER Hotel_hotel_no_TRG
BEFORE INSERT ON Hotel
FOR EACH ROW
BEGIN
IF :NEW.hotel_no IS NOT NULL THEN
  SELECT Hotel_hotel_no_SEQ.NEXTVAL INTO :NEW.hotel_no FROM DUAL;
END IF;
END;

COMMENT ON TABLE Hotel is 'Hotel';
COMMENT ON COLUMN Hotel.hotel_no is 'hotel_no';
COMMENT ON COLUMN Hotel.hotel_name is 'hotel_name';
COMMENT ON COLUMN Hotel.hotel_local is 'hotel_local';
COMMENT ON COLUMN Hotel.hotel_price is 'hotel_price';
COMMENT ON COLUMN Hotel.hotel_star is 'hotel_star';
COMMENT ON COLUMN Hotel.hotel_category is 'hotel_category';
COMMENT ON COLUMN Hotel.hotel_desc is 'hotel_desc';
COMMENT ON COLUMN Hotel.hotel_image is 'hotel_image';


/**********************************/
/* Table Name: HotelReview */
/**********************************/
CREATE TABLE HotelReview(
		hr_no                         		NUMBER(10)		 NULL ,
		hr_content                    		VARCHAR2(300)		 NULL ,
		hr_date                       		DATE		 NULL ,
		hr_star                       		DOUBLE PRECISION		 NULL ,
		hotel_no                      		NUMBER(10)		 NULL ,
		user_no                       		NUMBER(10)		 NULL 
);

COMMENT ON TABLE HotelReview is 'HotelReview';
COMMENT ON COLUMN HotelReview.hr_no is 'hr_no';
COMMENT ON COLUMN HotelReview.hr_content is 'hr_content';
COMMENT ON COLUMN HotelReview.hr_date is 'hr_date';
COMMENT ON COLUMN HotelReview.hr_star is 'hr_star';
COMMENT ON COLUMN HotelReview.hotel_no is 'hotel_no';
COMMENT ON COLUMN HotelReview.user_no is 'user_no';


/**********************************/
/* Table Name: HotelBooking */
/**********************************/
CREATE TABLE HotelBooking(
		hb_no                         		NUMBER(10)		 NULL ,
		hb_checkin                    		DATE		 NULL ,
		hb_checkout                   		DATE		 NULL ,
		hb_name                       		VARCHAR2(50)		 NULL ,
		hb_persons                    		NUMBER(10)		 NULL ,
		hb_phone                      		VARCHAR2(50)		 NULL ,
		hb_price                      		INTEGER(100)		 NULL ,
		hotel_no                      		NUMBER(10)		 NULL ,
		user_no                       		NUMBER(10)		 NULL 
);

DROP SEQUENCE HotelBooking_hb_no_SEQ;

CREATE SEQUENCE HotelBooking_hb_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

CREATE TRIGGER HotelBooking_hb_no_TRG
BEFORE INSERT ON HotelBooking
FOR EACH ROW
BEGIN
IF :NEW.hb_no IS NOT NULL THEN
  SELECT HotelBooking_hb_no_SEQ.NEXTVAL INTO :NEW.hb_no FROM DUAL;
END IF;
END;

COMMENT ON TABLE HotelBooking is 'HotelBooking';
COMMENT ON COLUMN HotelBooking.hb_no is 'hb_no';
COMMENT ON COLUMN HotelBooking.hb_checkin is 'hb_checkin';
COMMENT ON COLUMN HotelBooking.hb_checkout is 'hb_checkout';
COMMENT ON COLUMN HotelBooking.hb_name is 'hb_name';
COMMENT ON COLUMN HotelBooking.hb_persons is 'hb_persons';
COMMENT ON COLUMN HotelBooking.hb_phone is 'hb_phone';
COMMENT ON COLUMN HotelBooking.hb_price is 'hb_price';
COMMENT ON COLUMN HotelBooking.hotel_no is 'hotel_no';
COMMENT ON COLUMN HotelBooking.user_no is 'user_no';


/**********************************/
/* Table Name: Restaurant */
/**********************************/
CREATE TABLE Restaurant(
		restaurant_no                 		NUMBER(10)		 NULL ,
		restaurant_name               		VARCHAR2(50)		 NULL ,
		restaurant_image              		VARCHAR2(300)		 NULL ,
		restaurant_address            		VARCHAR2(100)		 NULL ,
		restaurant_star               		DOUBLE PRECISION		 NULL ,
		restaurant_tel                		VARCHAR2(100)		 NULL ,
		restaurant_category           		VARCHAR2(100)		 NULL 
);

DROP SEQUENCE Restaurant_restaurant_no_SEQ;

CREATE SEQUENCE Restaurant_restaurant_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

CREATE TRIGGER Restaurant_restaurant_no_TRG
BEFORE INSERT ON Restaurant
FOR EACH ROW
BEGIN
IF :NEW.restaurant_no IS NOT NULL THEN
  SELECT Restaurant_restaurant_no_SEQ.NEXTVAL INTO :NEW.restaurant_no FROM DUAL;
END IF;
END;

COMMENT ON TABLE Restaurant is 'Restaurant';
COMMENT ON COLUMN Restaurant.restaurant_no is 'restaurant_no';
COMMENT ON COLUMN Restaurant.restaurant_name is 'restaurant_name';
COMMENT ON COLUMN Restaurant.restaurant_image is 'restaurant_image';
COMMENT ON COLUMN Restaurant.restaurant_address is 'restaurant_address';
COMMENT ON COLUMN Restaurant.restaurant_star is 'restaurant_star';
COMMENT ON COLUMN Restaurant.restaurant_tel is 'restaurant_tel';
COMMENT ON COLUMN Restaurant.restaurant_category is 'restaurant_category';


/**********************************/
/* Table Name: RestaurantMenu */
/**********************************/
CREATE TABLE RestaurantMenu(
		rm_no                         		NUMBER(10)		 NULL ,
		rm_name                       		VARCHAR2(50)		 NULL ,
		rm_price                      		VARCHAR2(50)		 NULL ,
		rm_image                      		VARCHAR2(300)		 NULL ,
		restaurant_no                 		NUMBER(10)		 NULL 
);

DROP SEQUENCE RestaurantMenu_rm_no_SEQ;

CREATE SEQUENCE RestaurantMenu_rm_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

CREATE TRIGGER RestaurantMenu_rm_no_TRG
BEFORE INSERT ON RestaurantMenu
FOR EACH ROW
BEGIN
IF :NEW.rm_no IS NOT NULL THEN
  SELECT RestaurantMenu_rm_no_SEQ.NEXTVAL INTO :NEW.rm_no FROM DUAL;
END IF;
END;

COMMENT ON TABLE RestaurantMenu is 'RestaurantMenu';
COMMENT ON COLUMN RestaurantMenu.rm_no is 'rm_no';
COMMENT ON COLUMN RestaurantMenu.rm_name is 'rm_name';
COMMENT ON COLUMN RestaurantMenu.rm_price is 'rm_price';
COMMENT ON COLUMN RestaurantMenu.rm_image is 'rm_image';
COMMENT ON COLUMN RestaurantMenu.restaurant_no is 'restaurant_no';


/**********************************/
/* Table Name: RestaurantReview */
/**********************************/
CREATE TABLE RestaurantReview(
		rr_no                         		NUMBER(10)		 NULL ,
		rr_content                    		VARCHAR2(300)		 NULL ,
		rr_date                       		DATE		 NULL ,
		rr_star                       		DOUBLE PRECISION		 NULL ,
		restaurant_no                 		NUMBER(10)		 NULL ,
		user_no                       		NUMBER(10)		 NULL 
);

DROP SEQUENCE RestaurantReview_rr_no_SEQ;

CREATE SEQUENCE RestaurantReview_rr_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

CREATE TRIGGER RestaurantReview_rr_no_TRG
BEFORE INSERT ON RestaurantReview
FOR EACH ROW
BEGIN
IF :NEW.rr_no IS NOT NULL THEN
  SELECT RestaurantReview_rr_no_SEQ.NEXTVAL INTO :NEW.rr_no FROM DUAL;
END IF;
END;

COMMENT ON TABLE RestaurantReview is 'RestaurantReview';
COMMENT ON COLUMN RestaurantReview.rr_no is 'rr_no';
COMMENT ON COLUMN RestaurantReview.rr_content is 'rr_content';
COMMENT ON COLUMN RestaurantReview.rr_date is 'rr_date';
COMMENT ON COLUMN RestaurantReview.rr_star is 'rr_star';
COMMENT ON COLUMN RestaurantReview.restaurant_no is 'restaurant_no';
COMMENT ON COLUMN RestaurantReview.user_no is 'user_no';


/**********************************/
/* Table Name: RestaurantBooking */
/**********************************/
CREATE TABLE RestaurantBooking(
		rb_no                         		NUMBER(10)		 NULL ,
		rb_name                       		VARCHAR2(50)		 NULL ,
		rb_phone                      		VARCHAR2(50)		 NULL ,
		rb_date                       		DATE		 NULL ,
		rb_time                       		VARCHAR2(50)		 NULL ,
		rb_persons                    		NUMBER(10)		 NULL ,
		restaurant_no                 		NUMBER(10)		 NULL ,
		user_no                       		NUMBER(10)		 NULL 
);

DROP SEQUENCE RestaurantBooking_rb_no_SEQ;

CREATE SEQUENCE RestaurantBooking_rb_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

CREATE TRIGGER RestaurantBooking_rb_no_TRG
BEFORE INSERT ON RestaurantBooking
FOR EACH ROW
BEGIN
IF :NEW.rb_no IS NOT NULL THEN
  SELECT RestaurantBooking_rb_no_SEQ.NEXTVAL INTO :NEW.rb_no FROM DUAL;
END IF;
END;

COMMENT ON TABLE RestaurantBooking is 'RestaurantBooking';
COMMENT ON COLUMN RestaurantBooking.rb_no is 'rb_no';
COMMENT ON COLUMN RestaurantBooking.rb_name is 'rb_name';
COMMENT ON COLUMN RestaurantBooking.rb_phone is 'rb_phone';
COMMENT ON COLUMN RestaurantBooking.rb_date is 'rb_date';
COMMENT ON COLUMN RestaurantBooking.rb_time is 'rb_time';
COMMENT ON COLUMN RestaurantBooking.rb_persons is 'rb_persons';
COMMENT ON COLUMN RestaurantBooking.restaurant_no is 'restaurant_no';
COMMENT ON COLUMN RestaurantBooking.user_no is 'user_no';


/**********************************/
/* Table Name: Attraction */
/**********************************/
CREATE TABLE Attraction(
		attraction_no                 		NUMBER(10)		 NULL ,
		attraction_name               		VARCHAR2(50)		 NULL ,
		attraction_address            		VARCHAR2(50)		 NULL ,
		attraction_image              		VARCHAR2(300)		 NULL ,
		attraction_category           		VARCHAR2(50)		 NULL ,
		attraction_star               		DOUBLE PRECISION		 NULL 
);

DROP SEQUENCE Attraction_attraction_no_SEQ;

CREATE SEQUENCE Attraction_attraction_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

CREATE TRIGGER Attraction_attraction_no_TRG
BEFORE INSERT ON Attraction
FOR EACH ROW
BEGIN
IF :NEW.attraction_no IS NOT NULL THEN
  SELECT Attraction_attraction_no_SEQ.NEXTVAL INTO :NEW.attraction_no FROM DUAL;
END IF;
END;

COMMENT ON TABLE Attraction is 'Attraction';
COMMENT ON COLUMN Attraction.attraction_no is 'attraction_no';
COMMENT ON COLUMN Attraction.attraction_name is 'attraction_name';
COMMENT ON COLUMN Attraction.attraction_address is 'attraction_address';
COMMENT ON COLUMN Attraction.attraction_image is 'attraction_image';
COMMENT ON COLUMN Attraction.attraction_category is 'attraction_category';
COMMENT ON COLUMN Attraction.attraction_star is 'attraction_star';


/**********************************/
/* Table Name: Coupon */
/**********************************/
CREATE TABLE Coupon(
		coupon_no                     		NUMBER(10)		 NULL ,
		coupon_name                   		VARCHAR2(50)		 NULL ,
		coupon_discount               		NUMBER(50)		 NULL ,
		coupon_payday                 		DATE		 NULL ,
		coupon_expiredate             		DATE		 NULL ,
		user_no                       		NUMBER(10)		 NULL 
);

DROP SEQUENCE Coupon_coupon_no_SEQ;

CREATE SEQUENCE Coupon_coupon_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

CREATE TRIGGER Coupon_coupon_no_TRG
BEFORE INSERT ON Coupon
FOR EACH ROW
BEGIN
IF :NEW.coupon_no IS NOT NULL THEN
  SELECT Coupon_coupon_no_SEQ.NEXTVAL INTO :NEW.coupon_no FROM DUAL;
END IF;
END;

COMMENT ON TABLE Coupon is 'Coupon';
COMMENT ON COLUMN Coupon.coupon_no is 'coupon_no';
COMMENT ON COLUMN Coupon.coupon_name is 'coupon_name';
COMMENT ON COLUMN Coupon.coupon_discount is 'coupon_discount';
COMMENT ON COLUMN Coupon.coupon_payday is 'coupon_payday';
COMMENT ON COLUMN Coupon.coupon_expiredate is 'coupon_expiredate';
COMMENT ON COLUMN Coupon.user_no is 'user_no';


/**********************************/
/* Table Name: WIsh */
/**********************************/
CREATE TABLE WIsh(
		wish_no                       		NUMBER(10)		 NULL ,
		wish_category                 		VARCHAR2(50)		 NULL ,
		restaurant_no                 		NUMBER(10)		 NULL ,
		hotel_no                      		NUMBER(10)		 NULL ,
		user_no                       		NUMBER(10)		 NULL ,
		attraction_no                 		NUMBER(10)		 NULL 
);

DROP SEQUENCE WIsh_wish_no_SEQ;

CREATE SEQUENCE WIsh_wish_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

CREATE TRIGGER WIsh_wish_no_TRG
BEFORE INSERT ON WIsh
FOR EACH ROW
BEGIN
IF :NEW.wish_no IS NOT NULL THEN
  SELECT WIsh_wish_no_SEQ.NEXTVAL INTO :NEW.wish_no FROM DUAL;
END IF;
END;

COMMENT ON TABLE WIsh is 'WIsh';
COMMENT ON COLUMN WIsh.wish_no is 'wish_no';
COMMENT ON COLUMN WIsh.wish_category is 'wish_category';
COMMENT ON COLUMN WIsh.restaurant_no is 'restaurant_no';
COMMENT ON COLUMN WIsh.hotel_no is 'hotel_no';
COMMENT ON COLUMN WIsh.user_no is 'user_no';
COMMENT ON COLUMN WIsh.attraction_no is 'attraction_no';


/**********************************/
/* Table Name: HotelQnA */
/**********************************/
CREATE TABLE HotelQnA(
		qna_no                        		NUMBER(10)		 NULL ,
		qna_date                      		DATE		 NULL ,
		qna_name                      		VARCHAR2(50)		 NULL ,
		qna_password                  		VARCHAR2(50)		 NULL ,
		qna_title                     		VARCHAR2(50)		 NULL ,
		qna_content                   		VARCHAR2(300)		 NULL ,
		qna_group_no                  		NUMBER(10)		 NULL ,
		qna_step                      		NUMBER(10)		 NULL ,
		qna_depth                     		NUMBER(10)		 NULL ,
		hotel_no                      		NUMBER(10)		 NULL ,
		user_no                       		NUMBER(10)		 NULL 
);

DROP SEQUENCE HotelQnA_qna_no_SEQ;

CREATE SEQUENCE HotelQnA_qna_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

CREATE TRIGGER HotelQnA_qna_no_TRG
BEFORE INSERT ON HotelQnA
FOR EACH ROW
BEGIN
IF :NEW.qna_no IS NOT NULL THEN
  SELECT HotelQnA_qna_no_SEQ.NEXTVAL INTO :NEW.qna_no FROM DUAL;
END IF;
END;

COMMENT ON TABLE HotelQnA is 'HotelQnA';
COMMENT ON COLUMN HotelQnA.qna_no is 'qna_no';
COMMENT ON COLUMN HotelQnA.qna_date is 'qna_date';
COMMENT ON COLUMN HotelQnA.qna_name is 'qna_name';
COMMENT ON COLUMN HotelQnA.qna_password is 'qna_password';
COMMENT ON COLUMN HotelQnA.qna_title is 'qna_title';
COMMENT ON COLUMN HotelQnA.qna_content is 'qna_content';
COMMENT ON COLUMN HotelQnA.qna_group_no is 'qna_group_no';
COMMENT ON COLUMN HotelQnA.qna_step is 'qna_step';
COMMENT ON COLUMN HotelQnA.qna_depth is 'qna_depth';
COMMENT ON COLUMN HotelQnA.hotel_no is 'hotel_no';
COMMENT ON COLUMN HotelQnA.user_no is 'user_no';


/**********************************/
/* Table Name: AttractionReview */
/**********************************/
CREATE TABLE AttractionReview(
		ar_no                         		NUMBER(10)		 NULL ,
		ar_content                    		VARCHAR2(300)		 NULL ,
		ar_date                       		DATE		 NULL ,
		ar_star                       		DOUBLE PRECISION		 NULL ,
		attraction_no                 		NUMBER(10)		 NULL ,
		user_no                       		NUMBER(10)		 NULL 
);

DROP SEQUENCE AttractionReview_ar_no_SEQ;

CREATE SEQUENCE AttractionReview_ar_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

CREATE TRIGGER AttractionReview_ar_no_TRG
BEFORE INSERT ON AttractionReview
FOR EACH ROW
BEGIN
IF :NEW.ar_no IS NOT NULL THEN
  SELECT AttractionReview_ar_no_SEQ.NEXTVAL INTO :NEW.ar_no FROM DUAL;
END IF;
END;

COMMENT ON TABLE AttractionReview is 'AttractionReview';
COMMENT ON COLUMN AttractionReview.ar_no is 'ar_no';
COMMENT ON COLUMN AttractionReview.ar_content is 'ar_content';
COMMENT ON COLUMN AttractionReview.ar_date is 'ar_date';
COMMENT ON COLUMN AttractionReview.ar_star is 'ar_star';
COMMENT ON COLUMN AttractionReview.attraction_no is 'attraction_no';
COMMENT ON COLUMN AttractionReview.user_no is 'user_no';



ALTER TABLE Userinfo ADD CONSTRAINT IDX_Userinfo_PK PRIMARY KEY (user_no);

ALTER TABLE Hotel ADD CONSTRAINT IDX_Hotel_PK PRIMARY KEY (hotel_no);

ALTER TABLE HotelReview ADD CONSTRAINT IDX_HotelReview_FK0 FOREIGN KEY (hotel_no) REFERENCES Hotel (hotel_no);
ALTER TABLE HotelReview ADD CONSTRAINT IDX_HotelReview_FK1 FOREIGN KEY (user_no) REFERENCES Userinfo (user_no);

ALTER TABLE HotelBooking ADD CONSTRAINT IDX_HotelBooking_PK PRIMARY KEY (hb_no);
ALTER TABLE HotelBooking ADD CONSTRAINT IDX_HotelBooking_FK0 FOREIGN KEY (hotel_no) REFERENCES Hotel (hotel_no);
ALTER TABLE HotelBooking ADD CONSTRAINT IDX_HotelBooking_FK1 FOREIGN KEY (user_no) REFERENCES Userinfo (user_no);

ALTER TABLE Restaurant ADD CONSTRAINT IDX_Restaurant_PK PRIMARY KEY (restaurant_no);

ALTER TABLE RestaurantMenu ADD CONSTRAINT IDX_RestaurantMenu_PK PRIMARY KEY (rm_no);
ALTER TABLE RestaurantMenu ADD CONSTRAINT IDX_RestaurantMenu_FK0 FOREIGN KEY (restaurant_no) REFERENCES Restaurant (restaurant_no);

ALTER TABLE RestaurantReview ADD CONSTRAINT IDX_RestaurantReview_PK PRIMARY KEY (rr_no);
ALTER TABLE RestaurantReview ADD CONSTRAINT IDX_RestaurantReview_FK0 FOREIGN KEY (restaurant_no) REFERENCES Restaurant (restaurant_no);
ALTER TABLE RestaurantReview ADD CONSTRAINT IDX_RestaurantReview_FK1 FOREIGN KEY (user_no) REFERENCES Userinfo (user_no);

ALTER TABLE RestaurantBooking ADD CONSTRAINT IDX_RestaurantBooking_PK PRIMARY KEY (rb_no);
ALTER TABLE RestaurantBooking ADD CONSTRAINT IDX_RestaurantBooking_FK0 FOREIGN KEY (restaurant_no) REFERENCES Restaurant (restaurant_no);
ALTER TABLE RestaurantBooking ADD CONSTRAINT IDX_RestaurantBooking_FK1 FOREIGN KEY (user_no) REFERENCES Userinfo (user_no);

ALTER TABLE Attraction ADD CONSTRAINT IDX_Attraction_PK PRIMARY KEY (attraction_no);

ALTER TABLE Coupon ADD CONSTRAINT IDX_Coupon_PK PRIMARY KEY (coupon_no);
ALTER TABLE Coupon ADD CONSTRAINT IDX_Coupon_FK0 FOREIGN KEY (user_no) REFERENCES Userinfo (user_no);

ALTER TABLE WIsh ADD CONSTRAINT IDX_WIsh_PK PRIMARY KEY (wish_no);
ALTER TABLE WIsh ADD CONSTRAINT IDX_WIsh_FK0 FOREIGN KEY (restaurant_no) REFERENCES Restaurant (restaurant_no);
ALTER TABLE WIsh ADD CONSTRAINT IDX_WIsh_FK1 FOREIGN KEY (hotel_no) REFERENCES Hotel (hotel_no);
ALTER TABLE WIsh ADD CONSTRAINT IDX_WIsh_FK2 FOREIGN KEY (user_no) REFERENCES Userinfo (user_no);
ALTER TABLE WIsh ADD CONSTRAINT IDX_WIsh_FK3 FOREIGN KEY (attraction_no) REFERENCES Attraction (attraction_no);

ALTER TABLE HotelQnA ADD CONSTRAINT IDX_HotelQnA_PK PRIMARY KEY (qna_no);
ALTER TABLE HotelQnA ADD CONSTRAINT IDX_HotelQnA_FK0 FOREIGN KEY (hotel_no) REFERENCES Hotel (hotel_no);
ALTER TABLE HotelQnA ADD CONSTRAINT IDX_HotelQnA_FK1 FOREIGN KEY (user_no) REFERENCES Userinfo (user_no);

ALTER TABLE AttractionReview ADD CONSTRAINT IDX_AttractionReview_PK PRIMARY KEY (ar_no);
ALTER TABLE AttractionReview ADD CONSTRAINT IDX_AttractionReview_FK0 FOREIGN KEY (attraction_no) REFERENCES Attraction (attraction_no);
ALTER TABLE AttractionReview ADD CONSTRAINT IDX_AttractionReview_FK1 FOREIGN KEY (user_no) REFERENCES Userinfo (user_no);

