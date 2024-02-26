-- userinfo
insert into userinfo (user_no, user_id, user_password, user_name, user_resident, user_phone, user_email, user_point, user_register_date)
values (user_no_seq.nextval, 'admin', 'admin', 'admin', '000101-0000000', '010-0000-0000', 'aaaa@gamil.com', 0, sysdate);

insert into userinfo (user_no, user_id, user_password, user_name, user_resident, user_phone, user_email, user_point, user_register_date)
values (user_no_seq.nextval, 'aaaa', 'aaaa', 'aaaa', '000101-0000000', '010-0000-0000', 'aaaa@gamil.com', 0, sysdate);

insert into userinfo (user_no, user_id, user_password, user_name, user_resident, user_phone, user_email, user_point, user_register_date)
values (user_no_seq.nextval, 'bbbb', 'bbbb', 'bbbb', '000202-2222222', '010-2222-2222', 'bbbb@gamil.com', 0, sysdate);

insert into userinfo (user_no, user_id, user_password, user_name, user_resident, user_phone, user_email, user_point, user_register_date)
values (user_no_seq.nextval, 'cccc', 'cccc', 'cccc', '000303-3333333', '010-3333-3333', 'cccc@gamil.com', 0, sysdate);

insert into userinfo (user_no, user_id, user_password, user_name, user_resident, user_phone, user_email, user_point, user_register_date)
values (user_no_seq.nextval, 'dddd', 'dddd', 'dddd', '000404-4444444', '010-4444-4444', 'dddd@gamil.com', 0, sysdate);

insert into userinfo (user_no, user_id, user_password, user_name, user_resident, user_phone, user_email, user_point, user_register_date)
values (user_no_seq.nextval, 'eeee', 'eeee', 'eeee', '000505-5555555', '010-5555-5555', 'eeee@gamil.com', 0, sysdate);

insert into userinfo (user_no, user_id, user_password, user_name, user_resident, user_phone, user_email, user_point, user_register_date)
values (user_no_seq.nextval, 'ffff', 'ffff', 'ffff', '000606-6666666', '010-6666-6666', 'ffff@gamil.com', 0, sysdate);

insert into userinfo (user_no, user_id, user_password, user_name, user_resident, user_phone, user_email, user_point, user_register_date)
values (user_no_seq.nextval, 'gggg', 'gggg', 'gggg', '000707-7777777', '010-7777-7777', 'gggg@gamil.com', 0, sysdate);

insert into userinfo (user_no, user_id, user_password, user_name, user_resident, user_phone, user_email, user_point, user_register_date)
values (user_no_seq.nextval, 'hhhh', 'hhhh', 'hhhh', '000808-8888888', '010-1111-1111', 'hhhh@gamil.com', 0, sysdate);

insert into userinfo (user_no, user_id, user_password, user_name, user_resident, user_phone, user_email, user_point, user_register_date)
values (user_no_seq.nextval, 'iiii', 'iiii', 'iiii', '000909-9999999', '010-9999-9999', 'iiii@gamil.com', 0, sysdate);

insert into userinfo (user_no, user_id, user_password, user_name, user_resident, user_phone, user_email, user_point, user_register_date)
values (user_no_seq.nextval, 'jjjj', 'jjjj', 'jjjj', '001010-1010101', '010-1010-1010', 'jjjj@gamil.com', 0, sysdate);

-- hotel
insert into hotel (hotel_no, hotel_name, hotel_local, hotel_desc, hotel_star, hotel_price,hotel_map) 
values (hotel_no_seq.nextval, '제주 그 밤', '제주시 한림읍 한림해안로 534', '제주도 독채펜션', 0, 260000,'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3329.485331687199!2d126.27231297548893!3d33.43665997339506!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x350c5f159c5c0085%3A0xa91f94fac7665fc3!2z7KCc7KO8IOq3uCDrsKQ!5e0!3m2!1sko!2skr!4v1706246880427!5m2!1sko!2skr');

insert into hotel (hotel_no, hotel_name, hotel_local, hotel_desc, hotel_star, hotel_price,hotel_map) 
values (hotel_no_seq.nextval, '소공원스테이', '제주시 한경면 용금로 849', '소공원은 제주 서쪽, 한경면 저지예술인마을에 위치하고 있어 제주현대미술관과 유동룡미술관,김창열미술관 및 주변 갤러리, 그리고 방림원(식물원) 등을 도보로 방문하실 수 있습니다.', 0, 190000,'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3333.3148381347655!2d126.26416367548455!3d33.33672367343476!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x350c5da767745c35%3A0x4b4a4fbdc5db88e5!2z7IaM6rO17JuQ7Iqk7YWM7J20!5e0!3m2!1sko!2skr!4v1706246976337!5m2!1sko!2skr');

insert into hotel (hotel_no, hotel_name, hotel_local, hotel_desc, hotel_star, hotel_price,hotel_map)  
values (hotel_no_seq.nextval, '월림차경', '제주시 한림읍 월림5길 17', '자연을 거스르지 않고 주위의 풍경을 그대로 빌려 머무는 동안 예쁜 것들로만 가득가득 담으며 트망트망 행복하고 트망트망 사랑하길, 자연의 경치를 빌리다.', 0, 300000,'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3332.83144572808!2d126.25211377548507!3d33.34935307342968!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x350c679fd0167417%3A0x63e4bd896b11bd8b!2z7JuU66a87LCo6rK9!5e0!3m2!1sko!2skr!4v1706247237405!5m2!1sko!2skr');

insert into hotel (hotel_no, hotel_name, hotel_local, hotel_desc, hotel_star, hotel_price,hotel_map)  
values (hotel_no_seq.nextval, '나롯', '제주시 한경면 대한로 802-12', '제주도 서쪽 청수리에 위치한 2인 스테이입니다. 객실에 야외 자쿠지가 준비되어 있습니다.', 0, 190000,'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3334.802521785326!2d126.24263207548285!3d33.29782897345032!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x350c67a72624dc77%3A0x55b26bcd36f26c1b!2z64KY66Gv!5e0!3m2!1sko!2skr!4v1706247366384!5m2!1sko!2skr');

insert into hotel (hotel_no, hotel_name, hotel_local, hotel_desc, hotel_star, hotel_price,hotel_map) 
values (hotel_no_seq.nextval, '동명차경', '제주시 한림읍 명월성로 52', '일상에서 벗어나 온전히 머물다 가세요. 동명의 경치를 빌려드립니다.', 0, 260000,'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3330.7183893262268!2d126.26113757548768!3d33.40451047340776!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x350c5fd56816c50f%3A0x642d9fc78d438cf3!2z7KCc7KO87Yq567OE7J6Q7LmY64-EIOygnOyjvOyLnCDtlZzrprzsnY0g66qF7JuU7ISx66GcIDUy!5e0!3m2!1sko!2skr!4v1706247533385!5m2!1sko!2skr');

insert into hotel (hotel_no, hotel_name, hotel_local, hotel_desc, hotel_star, hotel_price,hotel_map) 
values (hotel_no_seq.nextval, '정취한가', '제주시 애월읍 수산리 462-1', '동백 앞마당, 작은 대나무정원, 자쿠지가 있는 온전히 쉼을 위한 하루한팀 2인 독채 스테이', 0, 220000,'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3328.241375416449!2d126.38221007549038!3d33.469065973382165!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x350cf7357c827a7f%3A0x423e376ddd74caea!2z7KCV7Leo7ZWc6rCA!5e0!3m2!1sko!2skr!4v1706247571476!5m2!1sko!2skr');

insert into hotel (hotel_no, hotel_name, hotel_local, hotel_desc, hotel_star, hotel_price,hotel_map) 
values (hotel_no_seq.nextval, '제주흐름', '제주시 조천읍 선흘동 1길 31-50번지', '감귤밭 사이 낮게 자리한 숙소 흐름', 0, 200000,'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3326.456318743927!2d126.69666257549255!3d33.5155196733638!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x350d1bf71af0a9df%3A0x5c1d9218cc5c0d8a!2z7KCc7KO87Yq567OE7J6Q7LmY64-EIOygnOyjvOyLnCDsobDsspzsnY0g7ISg7Z2Y64-ZMeq4uCAzMS01MA!5e0!3m2!1sko!2skr!4v1706247635322!5m2!1sko!2skr');

insert into hotel (hotel_no, hotel_name, hotel_local, hotel_desc, hotel_star, hotel_price,hotel_map)  
values (hotel_no_seq.nextval, '오에스테', '제주시 한경면 금등4길 94', '노을에 기대 제주 서쪽집, 오롯이 당신만을 위한 프라이빗 단독스테이', 0, 290000,'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3332.630422816605!2d126.19337777548519!3d33.35460387342764!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x350c679c8c9564c9%3A0x1cd01e16c6f228b0!2z7Jik7JeQ7Iqk7YWM!5e0!3m2!1sko!2skr!4v1706247736437!5m2!1sko!2skr');

insert into hotel (hotel_no, hotel_name, hotel_local, hotel_desc, hotel_star, hotel_price,hotel_map) 
values (hotel_no_seq.nextval, '도록도록', '제주시 구좌읍 종달논길 78', '우리의 여행이 오래도록 기억되도록', 0, 300000,'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3327.4257199312806!2d126.8974118754914!3d33.490299373373745!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x350d155477824f65%3A0x7d7357d59ea8d5fe!2z64-E66Gd64-E66Gd!5e0!3m2!1sko!2skr!4v1706247757335!5m2!1sko!2skr');

insert into hotel (hotel_no, hotel_name, hotel_local, hotel_desc, hotel_star, hotel_price,hotel_map) 
values (hotel_no_seq.nextval, '고등어민박', '제주시 구좌읍 해맞이해안로 1026', '잔잔하고 고요한 바닷가 앞, 이곳에서 지친 일상을 위로 받길 바래봅니다.', 0, 160000,'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3325.491505717178!2d126.82829857549368!3d33.54060397335389!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x350d16360f7ad255%3A0x33b692dc0c12ef4b!2z6rOg65Ox7Ja066-867CV!5e0!3m2!1sko!2skr!4v1706247780084!5m2!1sko!2skr');

-- hotel booking
insert into hotel_booking (hb_no, hotel_no, user_no, hb_name, hb_phone, hb_checkin, hb_checkout, hb_persons, hb_price)
values (hb_no_seq.nextval, 1, 1, '도경수', '010-1993-0112', TO_DATE('2023-01-12', 'yyyy-MM-dd'), TO_DATE('2023-01-13', 'yyyy-MM-dd'), 2, 260000);

insert into hotel_booking (hb_no, hotel_no, user_no, hb_name, hb_phone, hb_checkin, hb_checkout, hb_persons, hb_price)
values (hb_no_seq.nextval, 2, 1, '변백현', '010-1992-0506', TO_DATE('2023-05-06', 'yyyy-MM-dd'), TO_DATE('2023-05-17', 'yyyy-MM-dd'), 2, 190000);

insert into hotel_booking (hb_no, hotel_no, user_no, hb_name, hb_phone, hb_checkin, hb_checkout, hb_persons, hb_price)
values (hb_no_seq.nextval, 3, 3, '이준혁', '010-1984-0313', TO_DATE('2023-03-13', 'yyyy-MM-dd'), TO_DATE('2023-03-14', 'yyyy-MM-dd'), 2, 300000);

insert into hotel_booking (hb_no, hotel_no, user_no, hb_name, hb_phone, hb_checkin, hb_checkout, hb_persons, hb_price)
values (hb_no_seq.nextval, 4, 4, '장승조', '010-1981-1213', TO_DATE('2023-12-13', 'yyyy-MM-dd'), TO_DATE('2023-12-14', 'yyyy-MM-dd'), 2, 190000);

insert into hotel_booking (hb_no, hotel_no, user_no, hb_name, hb_phone, hb_checkin, hb_checkout, hb_persons, hb_price)
values (hb_no_seq.nextval, 5, 5, '차은우', '010-1997-0330', TO_DATE('2023-03-30', 'yyyy-MM-dd'), TO_DATE('2023-04-01', 'yyyy-MM-dd'), 2, 260000);

insert into hotel_booking (hb_no, hotel_no, user_no, hb_name, hb_phone, hb_checkin, hb_checkout, hb_persons, hb_price)
values (hb_no_seq.nextval, 6,6, '정성찬', '010-2001-0913', TO_DATE('2023-09-13', 'yyyy-MM-dd'), TO_DATE('2023-09-14', 'yyyy-MM-dd'), 2, 220000);

insert into hotel_booking (hb_no, hotel_no, user_no, hb_name, hb_phone, hb_checkin, hb_checkout, hb_persons, hb_price)
values (hb_no_seq.nextval, 7, 7, '하현상', '010-1998-0914', TO_DATE('2023-09-14', 'yyyy-MM-dd'), TO_DATE('2023-09-15', 'yyyy-MM-dd'), 2, 200000);

insert into hotel_booking (hb_no, hotel_no, user_no, hb_name, hb_phone, hb_checkin, hb_checkout, hb_persons, hb_price)
values (hb_no_seq.nextval, 8, 8, '유지민', '010-2000-0411', TO_DATE('2023-04-11', 'yyyy-MM-dd'), TO_DATE('2023-04-12', 'yyyy-MM-dd'), 2, 290000);

insert into hotel_booking (hb_no, hotel_no, user_no, hb_name, hb_phone, hb_checkin, hb_checkout, hb_persons, hb_price)
values (hb_no_seq.nextval, 9, 9, '장원영', '010-2004-0831', TO_DATE('2023-08-31', 'yyyy-MM-dd'), TO_DATE('2023-09-01', 'yyyy-MM-dd'), 2, 300000);

insert into hotel_booking (hb_no, hotel_no, user_no, hb_name, hb_phone, hb_checkin, hb_checkout, hb_persons, hb_price)
values (hb_no_seq.nextval, 10, 10, '채형원', '010-1994-0115', TO_DATE('2023-01-15', 'yyyy-MM-dd'), TO_DATE('2023-01-16', 'yyyy-MM-dd'), 2, 160000);

-- hotel category
insert into hotel_category (hc_no, hc_name) values (0, '');
insert into hotel_category (hc_no, hc_name) values (hc_no_seq.nextval, '오션뷰');
insert into hotel_category (hc_no, hc_name) values (hc_no_seq.nextval, '독채');
insert into hotel_category (hc_no, hc_name) values (hc_no_seq.nextval, '가든뷰');
insert into hotel_category (hc_no, hc_name) values (hc_no_seq.nextval, '게스트 하우스');
insert into hotel_category (hc_no, hc_name) values (hc_no_seq.nextval, '한옥');
insert into hotel_category (hc_no, hc_name) values (hc_no_seq.nextval, '풀빌라');
insert into hotel_category (hc_no, hc_name) values (hc_no_seq.nextval, '동쪽');
insert into hotel_category (hc_no, hc_name) values (hc_no_seq.nextval, '서쪽');
insert into hotel_category (hc_no, hc_name) values (hc_no_seq.nextval, '남쪽');
insert into hotel_category (hc_no, hc_name) values (hc_no_seq.nextval, '북쪽');
insert into hotel_category (hc_no, hc_name) values (hc_no_seq.nextval, '자쿠지');
insert into hotel_category (hc_no, hc_name) values (hc_no_seq.nextval, '펜션');
insert into hotel_category (hc_no, hc_name) values (hc_no_seq.nextval, '공항 근처');


-- hotel category item
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 1, 0);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 1, 2);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 1, 3);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 1, 0);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 1, 0);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 1, 0);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 1, 0);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 1, 8);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 1, 0);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 1, 0);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 1, 11);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 1, 0);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 1, 0);

insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 2, 0);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 2, 2);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 2, 3);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 2, 0);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 2, 0);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 2, 0);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 2, 7);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 2, 0);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 2, 0);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 2, 0);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 2, 11);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 2, 0);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 2, 0);

insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 3, 1);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 3, 2);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 3, 0);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 3, 0);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 3, 0);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 3, 0);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 3, 0);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 3, 8);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 3, 0);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 3, 0);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 3, 11);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 3, 0);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 3, 0);

insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 4, 1);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 4, 2);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 4, 0);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 4, 0);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 4, 0);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 4, 0);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 4, 0);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 4, 8);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 4, 0);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 4, 0);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 4, 11);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 4, 0);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 4, 0);

insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 5, 1);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 5, 2);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 5, 0);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 5, 0);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 5, 0);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 5, 0);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 5, 0);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 5, 0);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 5, 0);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 5, 10);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 5, 11);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 5, 0);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 5, 0);

insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 6, 0);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 6, 2);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 6, 3);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 6, 0);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 6, 0);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 6, 0);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 6, 0);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 6, 0);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 6, 9);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 6, 0);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 6, 11);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 6, 0);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 6, 0);

insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 7, 0);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 7, 2);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 7, 3);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 7, 0);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 7, 0);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 7, 0);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 7, 0);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 7, 0);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 7, 0);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 7, 0);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 7, 0);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 7, 12);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 7, 13);

insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 8, 0);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 8, 2);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 8, 3);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 8, 0);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 8, 0);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 8, 0);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 8, 0);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 8, 8);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 8, 0);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 8, 0);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 8, 11);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 8, 0);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 8, 0);

insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 9, 0);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 9, 0);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 9, 3);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 9, 0);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 9, 0);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 9, 6);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 9, 0);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 9, 0);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 9, 0);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 9, 0);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 9, 11);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 9, 12);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 9, 0);

insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 10, 1);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 10, 0);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 10, 0);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 10, 4);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 10, 0);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 10, 0);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 10, 7);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 10, 0);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 10, 0);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 10, 0);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 10, 0);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 10, 0);
insert into hotel_category_item (hci_no, hotel_no, hc_no) values (hci_no_seq.nextval, 10, 13);

-- hotel image
insert into hotel_image(image_no, image_name, hotel_no) values (hotel_image_seq.nextval, 'jejugeubam1.jpg', 1);
insert into hotel_image(image_no, image_name, hotel_no) values (hotel_image_seq.nextval, 'jejugeubam2.jpg', 1);
insert into hotel_image(image_no, image_name, hotel_no) values (hotel_image_seq.nextval, 'jejugeubam3.jpg', 1);
insert into hotel_image(image_no, image_name, hotel_no) values (hotel_image_seq.nextval, 'jejugeubam4.jpg', 1);

insert into hotel_image(image_no, image_name, hotel_no) values (hotel_image_seq.nextval, 'sogongwonstay1.jpg', 2);
insert into hotel_image(image_no, image_name, hotel_no) values (hotel_image_seq.nextval, 'sogongwonstay2.jpg', 2);
insert into hotel_image(image_no, image_name, hotel_no) values (hotel_image_seq.nextval, 'sogongwonstay3.jpg', 2);
insert into hotel_image(image_no, image_name, hotel_no) values (hotel_image_seq.nextval, 'sogongwonstay4.jpg', 2);

insert into hotel_image(image_no, image_name, hotel_no) values (hotel_image_seq.nextval, 'wollimchagyeong1.jpg', 3);
insert into hotel_image(image_no, image_name, hotel_no) values (hotel_image_seq.nextval, 'wollimchagyeong1.jpg', 3);
insert into hotel_image(image_no, image_name, hotel_no) values (hotel_image_seq.nextval, 'wollimchagyeong1.jpg', 3);
insert into hotel_image(image_no, image_name, hotel_no) values (hotel_image_seq.nextval, 'wollimchagyeong1.jpg', 3);

insert into hotel_image(image_no, image_name, hotel_no) values (hotel_image_seq.nextval, 'narot1.jpg', 4);
insert into hotel_image(image_no, image_name, hotel_no) values (hotel_image_seq.nextval, 'narot2.jpg', 4);
insert into hotel_image(image_no, image_name, hotel_no) values (hotel_image_seq.nextval, 'narot3.jpg', 4);
insert into hotel_image(image_no, image_name, hotel_no) values (hotel_image_seq.nextval, 'narot4.jpg', 4);

insert into hotel_image(image_no, image_name, hotel_no) values (hotel_image_seq.nextval, 'dongmyeongchagyeong1.jpg', 5);
insert into hotel_image(image_no, image_name, hotel_no) values (hotel_image_seq.nextval, 'dongmyeongchagyeong2.jpg', 5);
insert into hotel_image(image_no, image_name, hotel_no) values (hotel_image_seq.nextval, 'dongmyeongchagyeong3.jpg', 5);
insert into hotel_image(image_no, image_name, hotel_no) values (hotel_image_seq.nextval, 'dongmyeongchagyeong4.jpg', 5);

insert into hotel_image(image_no, image_name, hotel_no) values (hotel_image_seq.nextval, 'jeongchwihanga1.jpg', 6);
insert into hotel_image(image_no, image_name, hotel_no) values (hotel_image_seq.nextval, 'jeongchwihanga2.jpg', 6);
insert into hotel_image(image_no, image_name, hotel_no) values (hotel_image_seq.nextval, 'jeongchwihanga3.jpg', 6);
insert into hotel_image(image_no, image_name, hotel_no) values (hotel_image_seq.nextval, 'jeongchwihanga4.jpg', 6);

insert into hotel_image(image_no, image_name, hotel_no) values (hotel_image_seq.nextval, 'jejuheureum1.jpg', 7);
insert into hotel_image(image_no, image_name, hotel_no) values (hotel_image_seq.nextval, 'jejuheureum2.jpg', 7);
insert into hotel_image(image_no, image_name, hotel_no) values (hotel_image_seq.nextval, 'jejuheureum3.jpg', 7);
insert into hotel_image(image_no, image_name, hotel_no) values (hotel_image_seq.nextval, 'jejuheureum4.jpg', 7);

insert into hotel_image(image_no, image_name, hotel_no) values (hotel_image_seq.nextval, 'oeste1.jpg', 8);
insert into hotel_image(image_no, image_name, hotel_no) values (hotel_image_seq.nextval, 'oeste2.jpg', 8);
insert into hotel_image(image_no, image_name, hotel_no) values (hotel_image_seq.nextval, 'oeste3.jpg', 8);
insert into hotel_image(image_no, image_name, hotel_no) values (hotel_image_seq.nextval, 'oeste4.jpg', 8);

insert into hotel_image(image_no, image_name, hotel_no) values (hotel_image_seq.nextval, 'dorokdorok1.jpg', 9);
insert into hotel_image(image_no, image_name, hotel_no) values (hotel_image_seq.nextval, 'dorokdorok2.jpg', 9);
insert into hotel_image(image_no, image_name, hotel_no) values (hotel_image_seq.nextval, 'dorokdorok3.jpg', 9);
insert into hotel_image(image_no, image_name, hotel_no) values (hotel_image_seq.nextval, 'dorokdorok4.jpg', 9);

insert into hotel_image(image_no, image_name, hotel_no) values (hotel_image_seq.nextval, 'godeungeostay1.jpg', 10);
insert into hotel_image(image_no, image_name, hotel_no) values (hotel_image_seq.nextval, 'godeungeostay2.jpg', 10);
insert into hotel_image(image_no, image_name, hotel_no) values (hotel_image_seq.nextval, 'godeungeostay3.jpg', 10);
insert into hotel_image(image_no, image_name, hotel_no) values (hotel_image_seq.nextval, 'godeungeostay4.jpg', 10);

-- hotel qna
insert into hotel_qna (qna_no, hotel_no, user_no, qna_date, qna_name, qna_password, qna_title, qna_content, qna_group_no, qna_step, qna_depth)
values (qna_no_seq.nextval, 1, 1, sysdate, '도경수', 0112, '숙박 일정 문의합니다.', '장기 숙박 가능한가요 한 1년 정도?', 1, 1, 1);

insert into hotel_qna (qna_no, hotel_no, user_no, qna_date, qna_name, qna_password, qna_title, qna_content, qna_group_no, qna_step, qna_depth)
values (qna_no_seq.nextval, 2, null, sysdate, '변백현', 0506, '다인원 예약 가능한지 문의합니다.', '여러명 예약 가능한가요? 100명이서 가고 싶은데', 1, 1, 1);

insert into hotel_qna (qna_no, hotel_no, user_no, qna_date, qna_name, qna_password, qna_title, qna_content, qna_group_no, qna_step, qna_depth)
values (qna_no_seq.nextval, 3, null, sysdate, '이준혁', 0313, '가든뷰 문의합니다', '가든뷰라고 하셨는데 꽃도 있고 나무도 있나요? 얼마나 큰 가든이죠?', 1, 1, 1);

insert into hotel_qna (qna_no, hotel_no, user_no, qna_date, qna_name, qna_password, qna_title, qna_content, qna_group_no, qna_step, qna_depth)
values (qna_no_seq.nextval, 4, 5, sysdate, '차은우', 0330, '인원 관련 질문합니다.', '2인 스테이라고 하셨는데 3인은 안되나요? 애기라서 그냥 예약해서 들어가면 안되나요?', 1, 1, 1);

insert into hotel_qna (qna_no, hotel_no, user_no, qna_date, qna_name, qna_password, qna_title, qna_content, qna_group_no, qna_step, qna_depth)
values (qna_no_seq.nextval, 5, 6, sysdate, '하현상', 0914, '자쿠지 관련 문의합니다.', '자쿠지에 배쓰밤 사용 가능한가요~?', 1, 1, 1);

insert into hotel_qna (qna_no, hotel_no, user_no, qna_date, qna_name, qna_password, qna_title, qna_content, qna_group_no, qna_step, qna_depth)
values (qna_no_seq.nextval, 6, null, sysdate, '채형원', 0115, '예약문의', '제가 예약하고 싶은 날 이미 예약이 되어 있던데 그 사람들 죽이면 제가 예약할 수 있나요?', 1, 1, 1);

insert into hotel_qna (qna_no, hotel_no, user_no, qna_date, qna_name, qna_password, qna_title, qna_content, qna_group_no, qna_step, qna_depth)
values (qna_no_seq.nextval, 7, 3, sysdate, '장승조', 1213, '주차장 관련 질문 있어요', '4명이서 갈건데 차량이 4대여도 주차 가능해여?', 1, 1, 1);

insert into hotel_qna (qna_no, hotel_no, user_no, qna_date, qna_name, qna_password, qna_title, qna_content, qna_group_no, qna_step, qna_depth)
values (qna_no_seq.nextval, 8, null, sysdate, '정성찬', 0913, '수영장 질문', '제가 여자친구랑 기념일이라 가는 거라서요 수영장에 꽃을 가득 띄워주실 수 있는지 문의합니다', 1, 1, 1);

insert into hotel_qna (qna_no, hotel_no, user_no, qna_date, qna_name, qna_password, qna_title, qna_content, qna_group_no, qna_step, qna_depth)
values (qna_no_seq.nextval, 9, null, sysdate, '유지민', 0411, '가격 문의합니다', '비수기에 혼자 가는건데 할인 안되나요? 전 혼잔데 좀 해주세요', 1, 1, 1);

insert into hotel_qna (qna_no, hotel_no, user_no, qna_date, qna_name, qna_password, qna_title, qna_content, qna_group_no, qna_step, qna_depth)
values (qna_no_seq.nextval, 10, 2, sysdate, '장원영', 0831, '안전 관련 질문합니다.', '오션뷰라고 되어있던데 태풍이 오면 바다에 잠기는 거 아닌가요? 안전한거 맞나요?', 1, 1, 1);

-- hotel review
insert into hotel_review (hr_no, hotel_no, user_no, hr_date, hr_star, hr_content)
values (hr_no_seq.nextval, 1, 1, sysdate, 4, '너무 좋았습니다. 근데 숙소에 웰컴 푸드? 그런게 없더라고요 그게 좀 아쉽 ㅋ');

insert into hotel_review (hr_no, hotel_no, user_no, hr_date, hr_star, hr_content)
values (hr_no_seq.nextval, 2, 2, sysdate, 4, '미술관과 가까워서 볼 거리가 가까운 거리에 있어 좋았습니다. 근데 숙소에도 볼 수 있게 미술 작품 하나 정도 가져다 놨으면 더 좋았을 것 같네요 ㅋㅋ');

insert into hotel_review (hr_no, hotel_no, user_no, hr_date, hr_star, hr_content)
values (hr_no_seq.nextval, 3, 3, sysdate, 1, '좋아요 또 가고싶음 ㅋ');

insert into hotel_review (hr_no, hotel_no, user_no, hr_date, hr_star, hr_content)
values (hr_no_seq.nextval, 4, 4, sysdate, 3, '자쿠지가 야외에 있어서 좀 아쉬웠네요 ㅋ 다음에 또 오고싶어요');

insert into hotel_review (hr_no, hotel_no, user_no, hr_date, hr_star, hr_content)
values (hr_no_seq.nextval, 5, 5, sysdate, 2, '취사 가능이라더니 숙소에 재료는 하나도 없더라고요');

insert into hotel_review (hr_no, hotel_no, user_no, hr_date, hr_star, hr_content)
values (hr_no_seq.nextval, 6, 6, sysdate, 5, '프라이빗 숙소라고 했는데 정말 너무 프라이빗해서 좀 외로웠어요');

insert into hotel_review (hr_no, hotel_no, user_no, hr_date, hr_star, hr_content)
values (hr_no_seq.nextval, 7, 7, sysdate, 2, '귤나무가 보이는 뷰라 좋았는데 창문에서 바로 따 먹을 순 없더라고요ㅎㅋ 따먹을 수 있었으면 더 좋았을 것 같네영~');

insert into hotel_review (hr_no, hotel_no, user_no, hr_date, hr_star, hr_content)
values (hr_no_seq.nextval, 8, 8, sysdate, 5, '진짜 개개개별로임');

insert into hotel_review (hr_no, hotel_no, user_no, hr_date, hr_star, hr_content)
values (hr_no_seq.nextval, 9, 9, sysdate, 5, '걍 개좋음 꼭꼭 가보세요');

insert into hotel_review (hr_no, hotel_no, user_no, hr_date, hr_star, hr_content)
values (hr_no_seq.nextval, 10, 10, sysdate, 3, '오션뷰라 좋은데 파도소리가 많이 들려서 잘 때 힘들었어요 ㅎㅋ');

-- hotelAmenity
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,1);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,1);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,1);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,1);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,1);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,1);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,1);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,1);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,1);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,1);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,1);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,1);

insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,2);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,2);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,2);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,2);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,2);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,2);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,2);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,2);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,2);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,2);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,2);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,2);

insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,3);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,3);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,3);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,3);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,3);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,3);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,3);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,3);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,3);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,3);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,3);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,3);

insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,4);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,4);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,4);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,4);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,4);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,4);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,4);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,4);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,4);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,4);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,4);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,4);

insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,5);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,5);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,5);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,5);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,5);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,5);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,5);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,5);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,5);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,5);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,5);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,5);

insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,6);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,6);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,6);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,6);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,6);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,6);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,6);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,6);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,6);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,6);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,6);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,6);

insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,7);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,7);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,7);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,7);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,7);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,7);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,7);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,7);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,7);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,7);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,7);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,7);

insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,8);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,8);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,8);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,8);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,8);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,8);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,8);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,8);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,8);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,8);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,8);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,8);

insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,9);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,9);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,9);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,9);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,9);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,9);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,9);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,9);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,9);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,9);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,9);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,9);

insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,10);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,10);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,10);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,10);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,10);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,10);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,10);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,10);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,10);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,10);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,10);
insert into hotel_amenity(hotel_amenity.ha_no,hotel_amenity.ha_check,hotel_amenity.hotel_no) values (ha_no_seq.nextval,1,10);

-- attraction
insert into attraction (attraction_no, attraction_name, attraction_address, attraction_desc, attraction_star,attraction_map)
values(attraction_no_seq.nextval, '카멜리아힐', '제주 서귀포시 안덕면 병악로 166', '카멜리아힐 설명', 0,'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3335.109244442443!2d126.36572337548247!3d33.28980487345352!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x350c5b755d81da01%3A0xea6d4e1147bdb92f!2z7Lm066mc66as7JWEIO2ekA!5e0!3m2!1sko!2skr!4v1706244917985!5m2!1sko!2skr');

insert into attraction (attraction_no, attraction_name, attraction_address, attraction_desc, attraction_star,attraction_map)
values(attraction_no_seq.nextval, '한라산', '제주 서귀포시 토평동 산15-1', '한라산 설명', 0,'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d26658.881918025152!2d126.49019779477854!3d33.361660013305546!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x350cff51e4901447%3A0x9e789970e40c6824!2z7ZWc65287IKw!5e0!3m2!1sko!2skr!4v1706245005772!5m2!1sko!2skr');

insert into attraction (attraction_no, attraction_name, attraction_address, attraction_desc, attraction_star,attraction_map)
values(attraction_no_seq.nextval, '금오름', '제주 제주시 한림읍 금악리 산1-1', '금오름 설명', 0,'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d53321.49062922455!2d126.23764369913634!3d33.355577000000004!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x350c5e7de56a2c13%3A0x490f203247148e3c!2z6riI7Jik66aE!5e0!3m2!1sko!2skr!4v1706245093786!5m2!1sko!2skr');

insert into attraction (attraction_no, attraction_name, attraction_address, attraction_desc, attraction_star,attraction_map)
values(attraction_no_seq.nextval, '9.81파크 제주', '제주 제주시 애월읍 천덕로 880-24', '9.81파크 제주 설명', 0,'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3961.582224264429!2d126.36319772308164!3d33.389850937838354!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x350cfcaee389e537%3A0xb1b8a666bc10abe1!2zOS44MSDtjIztgaw!5e0!3m2!1sko!2skr!4v1706245128433!5m2!1sko!2skr');

insert into attraction (attraction_no, attraction_name, attraction_address, attraction_desc, attraction_star,attraction_map)
values(attraction_no_seq.nextval, '스누피가든', '제주 제주시 구좌읍 금백조로 930', '스누피가든 설명', 0,'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3329.196099218434!2d126.77573087548936!3d33.44419717339202!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x350d1bc32bdef82d%3A0x35c7b3cf574c06f5!2z7Iqk64iE7ZS86rCA65Og!5e0!3m2!1sko!2skr!4v1706245179195!5m2!1sko!2skr');

insert into attraction (attraction_no, attraction_name, attraction_address, attraction_desc, attraction_star,attraction_map)
values(attraction_no_seq.nextval, '절물자연휴양림', '제주 제주시 명림로 584', '절물자연휴양림 설명', 0,'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3329.3785205469317!2d126.62687037548916!3d33.43944357339393!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x350d028a57908a03%3A0xc63886f8dea2926d!2z7KCc7KO87KCI66y87J6Q7Jew7Zy07JaR66a8!5e0!3m2!1sko!2skr!4v1706245209151!5m2!1sko!2skr');

insert into attraction (attraction_no, attraction_name, attraction_address, attraction_desc, attraction_star,attraction_map)
values(attraction_no_seq.nextval, '이호테오해수욕장', '제주 제주시 이호일동', '이호테오해수욕장 설명', 0,'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3327.1665328435697!2d126.45161442549173!3d33.497044123371104!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x350cfa8a5673bcb3%3A0xb37de163b6d9e624!2z7J207Zi47YWM7Jqw7ZW07IiY7JqV7J6l!5e0!3m2!1sko!2skr!4v1706245259714!5m2!1sko!2skr');

insert into attraction (attraction_no, attraction_name, attraction_address, attraction_desc, attraction_star,attraction_map)
values(attraction_no_seq.nextval, '대포주상절리', '제주 서귀포시 이어도로 36-24', '대포주상절리 설명', 0,'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3337.1036123022686!2d126.42365322548012!3d33.23758887347462!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x350c5aae28a7d773%3A0x500958317da3a1c6!2z7KO87IOB7KCI66as64yA!5e0!3m2!1sko!2skr!4v1706245304625!5m2!1sko!2skr');

insert into attraction (attraction_no, attraction_name, attraction_address, attraction_desc, attraction_star,attraction_map)
values(attraction_no_seq.nextval, '유민미술관', '제주 서귀포시 성산읍 섭지코지로 107', '유민미술관 설명', 0,'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3329.7727648790105!2d126.92971617548865!3d33.42916817339796!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x350d136a85b37e8b%3A0xc7533a3cb45806e6!2z7Jyg66-866-47Iig6rSA!5e0!3m2!1sko!2skr!4v1706245332051!5m2!1sko!2skr');

insert into attraction (attraction_no, attraction_name, attraction_address, attraction_desc, attraction_star,attraction_map)
values(attraction_no_seq.nextval, '본태박물관', '제주 서귀포시 안덕면 산록남로762번길 69 본태박물관', '본태박물관 설명', 0,'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3334.573082091162!2d126.38992747548315!3d33.30383017344797!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x350c5bcadc89eda3%3A0x8516de2611dedec2!2z67O47YOc67CV66y86rSA!5e0!3m2!1sko!2skr!4v1706245355325!5m2!1sko!2skr');

insert into attraction (attraction_no, attraction_name, attraction_address, attraction_desc, attraction_star,attraction_map)
values(attraction_no_seq.nextval, '본태박물관', '제주 서귀포시 안덕면 산록남로762번길 69 본태박물관', '본태박물관 설명', 0,'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3334.573082091162!2d126.38992747548315!3d33.30383017344797!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x350c5bcadc89eda3%3A0x8516de2611dedec2!2z67O47YOc67CV66y86rSA!5e0!3m2!1sko!2skr!4v1706245355325!5m2!1sko!2skr');

-- attraction category
insert into attraction_category (ac_no, ac_name) values (ac_no_seq.nextval, '해수욕장, 해변');
insert into attraction_category (ac_no, ac_name) values (ac_no_seq.nextval, '박물관');
insert into attraction_category (ac_no, ac_name) values (ac_no_seq.nextval, '미술관');
insert into attraction_category (ac_no, ac_name) values (ac_no_seq.nextval, '식물원, 수목원');
insert into attraction_category (ac_no, ac_name) values (ac_no_seq.nextval, '산');
insert into attraction_category (ac_no, ac_name) values (ac_no_seq.nextval, '관람, 체험');
insert into attraction_category (ac_no, ac_name) values (ac_no_seq.nextval, '기념물');
insert into attraction_category (ac_no, ac_name) values (ac_no_seq.nextval, '오름');
insert into attraction_category (ac_no, ac_name) values (ac_no_seq.nextval, '테마파크');
insert into attraction_category (ac_no, ac_name) values (ac_no_seq.nextval, '문화재');

-- attraction category item
insert into attraction_category_item (aci_no, attraction_no, ac_no) values (aci_no_seq.nextval, 1, 4);
insert into attraction_category_item (aci_no, attraction_no, ac_no) values (aci_no_seq.nextval, 2, 5);
insert into attraction_category_item (aci_no, attraction_no, ac_no) values (aci_no_seq.nextval, 3, 8);
insert into attraction_category_item (aci_no, attraction_no, ac_no) values (aci_no_seq.nextval, 4, 9);
insert into attraction_category_item (aci_no, attraction_no, ac_no) values (aci_no_seq.nextval, 5, 6);
insert into attraction_category_item (aci_no, attraction_no, ac_no) values (aci_no_seq.nextval, 6, 4);
insert into attraction_category_item (aci_no, attraction_no, ac_no) values (aci_no_seq.nextval, 7, 1);
insert into attraction_category_item (aci_no, attraction_no, ac_no) values (aci_no_seq.nextval, 8, 7);
insert into attraction_category_item (aci_no, attraction_no, ac_no) values (aci_no_seq.nextval, 9, 3);
insert into attraction_category_item (aci_no, attraction_no, ac_no) values (aci_no_seq.nextval, 10, 2);

-- attraction Image
insert into attraction_image(image_no, image_name, attraction_no) values (attraction_image_seq.nextval,'kamelliahil1.jpeg',1);
insert into attraction_image(image_no, image_name, attraction_no) values (attraction_image_seq.nextval,'kamelliahil2.jpeg',1);
insert into attraction_image(image_no, image_name, attraction_no) values (attraction_image_seq.nextval,'kamelliahil3.jpeg',1);

insert into attraction_image(image_no, image_name, attraction_no) values (attraction_image_seq.nextval,'hanrasan1.jpeg',2);
insert into attraction_image(image_no, image_name, attraction_no) values (attraction_image_seq.nextval,'hanrasan2.jpeg',2);
insert into attraction_image(image_no, image_name, attraction_no) values (attraction_image_seq.nextval,'hanrasan3.jpeg',2);

insert into attraction_image(image_no, image_name, attraction_no) values (attraction_image_seq.nextval,'geumoreum1.jpeg',3);
insert into attraction_image(image_no, image_name, attraction_no) values (attraction_image_seq.nextval,'geumoreum2.jpeg',3);
insert into attraction_image(image_no, image_name, attraction_no) values (attraction_image_seq.nextval,'geumoreum3.jpeg',3);

insert into attraction_image(image_no, image_name, attraction_no) values (attraction_image_seq.nextval,'pakeujeju1.jpeg',4);
insert into attraction_image(image_no, image_name, attraction_no) values (attraction_image_seq.nextval,'pakeujeju2.jpeg',4);
insert into attraction_image(image_no, image_name, attraction_no) values (attraction_image_seq.nextval,'pakeujeju3.jpeg',4);

insert into attraction_image(image_no, image_name, attraction_no) values (attraction_image_seq.nextval,'seunupigadeun1.jpeg',5);
insert into attraction_image(image_no, image_name, attraction_no) values (attraction_image_seq.nextval,'seunupigadeun2.jpeg',5);
insert into attraction_image(image_no, image_name, attraction_no) values (attraction_image_seq.nextval,'seunupigadeun3.jpeg',5);

insert into attraction_image(image_no, image_name, attraction_no) values (attraction_image_seq.nextval,'jeolmul1.jpeg',6);
insert into attraction_image(image_no, image_name, attraction_no) values (attraction_image_seq.nextval,'jeolmul2.jpeg',6);
insert into attraction_image(image_no, image_name, attraction_no) values (attraction_image_seq.nextval,'jeolmul3.jpeg',6);

insert into attraction_image(image_no, image_name, attraction_no) values (attraction_image_seq.nextval,'ihoteo1.jpeg',7);
insert into attraction_image(image_no, image_name, attraction_no) values (attraction_image_seq.nextval,'ihoteo2.jpeg',7);
insert into attraction_image(image_no, image_name, attraction_no) values (attraction_image_seq.nextval,'ihoteo3.jpeg',7);

insert into attraction_image(image_no, image_name, attraction_no) values (attraction_image_seq.nextval,'jusangjeolli1.jpeg',8);
insert into attraction_image(image_no, image_name, attraction_no) values (attraction_image_seq.nextval,'jusangjeolli2.jpeg',8);
insert into attraction_image(image_no, image_name, attraction_no) values (attraction_image_seq.nextval,'jusangjeolli3.jpeg',8);

insert into attraction_image(image_no, image_name, attraction_no) values (attraction_image_seq.nextval,'yuminmisulgwan1.jpeg',9);
insert into attraction_image(image_no, image_name, attraction_no) values (attraction_image_seq.nextval,'yuminmisulgwan2.jpeg',9);
insert into attraction_image(image_no, image_name, attraction_no) values (attraction_image_seq.nextval,'yuminmisulgwan3.jpeg',9);

insert into attraction_image(image_no, image_name, attraction_no) values (attraction_image_seq.nextval,'bontaebakmulgwan1.jpeg',10);
insert into attraction_image(image_no, image_name, attraction_no) values (attraction_image_seq.nextval,'bontaebakmulgwan2.jpeg',10);
insert into attraction_image(image_no, image_name, attraction_no) values (attraction_image_seq.nextval,'bontaebakmulgwan3.jpeg',10);

insert into attraction_image(image_no, image_name, attraction_no) values (attraction_image_seq.nextval,'bontaebakmulgwan1.jpeg',11);
insert into attraction_image(image_no, image_name, attraction_no) values (attraction_image_seq.nextval,'bontaebakmulgwan2.jpeg',11);
insert into attraction_image(image_no, image_name, attraction_no) values (attraction_image_seq.nextval,'bontaebakmulgwan3.jpeg',11);

-- attraction review
insert into attraction_review (ar_no, attraction_no, user_no, ar_content, ar_date, ar_star)
values (ar_no_seq.nextval, 1, 1, '좋아요', sysdate, 0.0);

insert into attraction_review (ar_no, attraction_no, user_no, ar_content, ar_date, ar_star)
values (ar_no_seq.nextval, 1, 2, '좋아요', sysdate, 1.0);

insert into attraction_review (ar_no, attraction_no, user_no, ar_content, ar_date, ar_star)
values (ar_no_seq.nextval, 1, 3, '좋아요', sysdate, 2.0);

insert into attraction_review (ar_no, attraction_no, user_no, ar_content, ar_date, ar_star)
values (ar_no_seq.nextval, 1, 4, '좋아요', sysdate, 3.0);

insert into attraction_review (ar_no, attraction_no, user_no, ar_content, ar_date, ar_star)
values (ar_no_seq.nextval, 1, 5, '좋아요', sysdate, 4.0);

insert into attraction_review (ar_no, attraction_no, user_no, ar_content, ar_date, ar_star)
values (ar_no_seq.nextval, 2, 1, '별로예요', sysdate, 0.0);

insert into attraction_review (ar_no, attraction_no, user_no, ar_content, ar_date, ar_star)
values (ar_no_seq.nextval, 2, 2, '별로예요', sysdate, 1.0);

insert into attraction_review (ar_no, attraction_no, user_no, ar_content, ar_date, ar_star)
values (ar_no_seq.nextval, 2, 3, '별로예요', sysdate, 2.0);

insert into attraction_review (ar_no, attraction_no, user_no, ar_content, ar_date, ar_star)
values (ar_no_seq.nextval, 2, 4, '별로예요', sysdate, 3.0);

insert into attraction_review (ar_no, attraction_no, user_no, ar_content, ar_date, ar_star)
values (ar_no_seq.nextval, 2, 5, '별로예요', sysdate, 4.0);

insert into attraction_review (ar_no, attraction_no, user_no, ar_content, ar_date, ar_star)
values (ar_no_seq.nextval, 21, 5, '별로예요', sysdate, 4.0);

-- restaurant
insert into restaurant (restaurant_no, restaurant_name, restaurant_address, restaurant_tel, restaurant_star,restaurant_map)
values (restaurant_seq.nextval, '제주광해 애월', '제주 제주시 애월읍 애월해안로 867 2층', '0507-1312-4789', 0 , 'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3327.5232727731427!2d126.38785577549123!3d33.487760473374756!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x350cf127ccb350bb%3A0xde330eca9eff03b5!2z7KCc7KO87Yq567OE7J6Q7LmY64-EIOygnOyjvOyLnCDslaDsm5TsnY0g7JWg7JuU7ZW07JWI66GcIDg2NyAy7Li1!5e0!3m2!1sko!2skr!4v1704874685356!5m2!1sko!2skr');

insert into restaurant (restaurant_no, restaurant_name, restaurant_address, restaurant_tel, restaurant_star,restaurant_map)
values (restaurant_seq.nextval, '연돈', '제주 서귀포시 색달로 10 2층 연돈', '0507-1386-7060', 0,'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3336.277857122457!2d126.40318917548106!3d33.259217373465745!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x350c5bc3e1cdc0bd%3A0x22be2eedc74c07a4!2z7Jew64-I!5e0!3m2!1sko!2skr!4v1706244133223!5m2!1sko!2skr');

insert into restaurant (restaurant_no, restaurant_name, restaurant_address, restaurant_tel, restaurant_star,restaurant_map)
values (restaurant_seq.nextval, '곶자왈화덕피자', '제주 서귀포시 대정읍 상모로 175 곶자왈화덕피자', '0507-1462-0994', 0,'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3337.5540388576997!2d126.26728837547962!3d33.22578587347938!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x350c433c2d1120e1%3A0x5f796b8dcb54c6c8!2z6rO27J6Q7JmI7ZmU642V7ZS87J6Q!5e0!3m2!1sko!2skr!4v1706244203290!5m2!1sko!2skr');

insert into restaurant (restaurant_no, restaurant_name, restaurant_address, restaurant_tel, restaurant_star,restaurant_map)
values (restaurant_seq.nextval, '자매국수', '제주 제주시 항골남길 46 자매국수', '064-746-2222', 0,'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3327.108110189668!2d126.45621307549177!3d33.49856427337041!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x350ce352935403cb%3A0x8a84d669b6d4557e!2z7J6Q66ek6rWt7IiY!5e0!3m2!1sko!2skr!4v1706244243762!5m2!1sko!2skr');

insert into restaurant (restaurant_no, restaurant_name, restaurant_address, restaurant_tel, restaurant_star,restaurant_map)
values (restaurant_seq.nextval, '해녀김밥 본점', '제주 제주시 조천읍 함덕로 40 3층, 302호', '0507-1342-3005', 0,'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3325.4226713713683!2d126.66867307549363!3d33.54239297335312!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x350d1c20b0de7aeb%3A0xadf31f2373318ee3!2z7ZW064WA6rmA67ClIOuzuOygkA!5e0!3m2!1sko!2skr!4v1706244408326!5m2!1sko!2skr');

insert into restaurant (restaurant_no, restaurant_name, restaurant_address, restaurant_tel, restaurant_star,restaurant_map)
values (restaurant_seq.nextval, '중문 돌담흑돼지', '제주 서귀포시 일주서로 909 1층', '0507-1391-4619', 0,'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3336.3332430435007!2d126.41065827548108!3d33.257767073466496!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x350c5b2637106941%3A0xac136c0158a83422!2z64-M64u07Z2R64-87KeA7KSR66y4!5e0!3m2!1sko!2skr!4v1706244444760!5m2!1sko!2skr');

insert into restaurant (restaurant_no, restaurant_name, restaurant_address, restaurant_tel, restaurant_star,restaurant_map)
values (restaurant_seq.nextval, '성산일출봉 아시횟집', '제주 서귀포시 성산읍 성산등용로 19', '0507-1343-3987', 0,'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3328.386224443359!2d126.9298333754902!3d33.46529397338357!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x350d1545d9c0cf99%3A0xa56b1b5cc795eca!2z7JWE7Iuc7Zqf7KeR!5e0!3m2!1sko!2skr!4v1706244547523!5m2!1sko!2skr');

insert into restaurant (restaurant_no, restaurant_name, restaurant_address, restaurant_tel, restaurant_star,restaurant_map)
values (restaurant_seq.nextval, '제갈양 제주협재점', '제주 제주시 한림읍 한림로 155', '0507-1413-9933', 0,'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3331.427790081834!2d126.22213977548678!3d33.38600187341515!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x350c60d7497c79fd%3A0xb371ea986fe54306!2z7KCc6rCI7JaR!5e0!3m2!1sko!2skr!4v1706244581528!5m2!1sko!2skr');

insert into restaurant (restaurant_no, restaurant_name, restaurant_address, restaurant_tel, restaurant_star,restaurant_map)
values (restaurant_seq.nextval, '레이지 펌프', '제주 제주시 애월읍 애월북서길 32 lazypump', '0507-1325-8732', 0,'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3328.3589722697902!2d126.30722047549035!3d33.46600367338339!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x350cf53082f59e13%3A0x6f7ea803face8300!2z66CI7J207KeA7Y6M7ZSE!5e0!3m2!1sko!2skr!4v1706244611006!5m2!1sko!2skr');

insert into restaurant (restaurant_no, restaurant_name, restaurant_address, restaurant_tel, restaurant_star,restaurant_map)
values (restaurant_seq.nextval, '우무', '제주 제주시 한림읍 한림로 542-1', '0507-1327-0064', 0,'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d106507.520639873!2d126.22739398820553!3d33.465976388784895!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x350c61e6c92f6c03%3A0x5967c29e05b668bd!2z7Jqw66y0IOuzuOygkA!5e0!3m2!1sko!2skr!4v1706244684734!5m2!1sko!2skr');

-- restaurant Faq
insert into restaurant_qna (rq_no,rq_question,rq_answer,restaurant_no) values (rq_no_seq.nextval,'최대 몇명까지 예약이 가능한가요?','저희 식당은 최대 4명까지 가능합니다. 단체예약은 전화로 부탁드립니다.',1);
insert into restaurant_qna (rq_no,rq_question,rq_answer,restaurant_no) values (rq_no_seq.nextval,'대기공간이 있나요?','대기공간이 따로 마련되어있지않습니다.',1);
insert into restaurant_qna (rq_no,rq_question,rq_answer,restaurant_no) values (rq_no_seq.nextval,'휴무일이 언제인가요?','저희 식당은 매주 수요일 입니다.',1);
insert into restaurant_qna (rq_no,rq_question,rq_answer,restaurant_no) values (rq_no_seq.nextval,'매장 오픈시간이 언제인가요?','오전 10시부터 오후 8시까지 영업합니다 7시까지 마지막 주문을 받습니다. 재료소진시 조기마감 될 수 있습니다.',1);

insert into restaurant_qna (rq_no,rq_question,rq_answer,restaurant_no) values (rq_no_seq.nextval,'주차장 비용은 얼마인가요?','오전에 대기로 주차장을 사용하시는 손님들은 오전 10시 30분까지 무료입니다.',2);
insert into restaurant_qna (rq_no,rq_question,rq_answer,restaurant_no) values (rq_no_seq.nextval,'매장 오픈시간이 언제인가요?','오후 12시부터 오후 9시까지 영업합니다 오후 7시 15분까지 마지막 주문을 받습니다. 재료소진시 조기마감 될 수 있습니다.',2);

insert into restaurant_qna (rq_no,rq_question,rq_answer,restaurant_no) values (rq_no_seq.nextval,'매장 오픈시간이 언제인가요?','오전 11시부터 오후9시까지 영업합니다.',3);
insert into restaurant_qna (rq_no,rq_question,rq_answer,restaurant_no) values (rq_no_seq.nextval,'휴무일이 언제인가요?','매주 수요일 휴무입니다.',3);
insert into restaurant_qna (rq_no,rq_question,rq_answer,restaurant_no) values (rq_no_seq.nextval,'3토핑 피자는 몇명이서 먹을 수 있나요?','4~6인용 피자이며 남은 음식은 포장이 가능합니다. 포장은 셀프입니다.',3);

insert into restaurant_qna (rq_no,rq_question,rq_answer,restaurant_no) values (rq_no_seq.nextval,'매장 영업시간은 어떻게되나요?','오전 9시부터 오후 6시까지 영업합니다. 쉬는시간은 오후 2시 30분부터 4시 10분까지 입니다. 마지막 주문은 5시 50분까지 입니다. 쉬는시간 전 마감이 변동적이니 확인 후 방문해주세요.',4);
insert into restaurant_qna (rq_no,rq_question,rq_answer,restaurant_no) values (rq_no_seq.nextval,'휴무일이 언제인가요?','매주 수요일 휴무입니다.',4);
insert into restaurant_qna (rq_no,rq_question,rq_answer,restaurant_no) values (rq_no_seq.nextval,'한 팀당 대기시간이 얼마정도 되나요?','10팀 기준 약 10분 ~ 15분 소요됩니다.',4);

insert into restaurant_qna (rq_no,rq_question,rq_answer,restaurant_no) values (rq_no_seq.nextval,'매장 영업시간은 어떻게되나요?','오전 9시부터 오후 5시까지 영업합니다. 재료소진시 조기마감됩니다.',5);
insert into restaurant_qna (rq_no,rq_question,rq_answer,restaurant_no) values (rq_no_seq.nextval,'휴무일이 언제인가요?','매주 일요일 휴무입니다.',5); 
insert into restaurant_qna (rq_no,rq_question,rq_answer,restaurant_no) values (rq_no_seq.nextval,'주차장이 만차시 이용할 곳은 없나요?','함덕 해수욕장 공영 주차장 또는 소노벨함덕 주차장 이용 후 도보 이동하시면 됩니다.',5);
insert into restaurant_qna (rq_no,rq_question,rq_answer,restaurant_no) values (rq_no_seq.nextval,'지역화폐 사용가능한가요?','지류,카드,모바일 모두 가능합니다.',5);

insert into restaurant_qna (rq_no,rq_question,rq_answer,restaurant_no) values (rq_no_seq.nextval,'매장 영업시간은 어떻게되나요?','오전 11시부터 자정까지 영업합니다. 오후11시에 마지막 주문을 받습니다.',6);
insert into restaurant_qna (rq_no,rq_question,rq_answer,restaurant_no) values (rq_no_seq.nextval,'휴무일이 언제인가요?','저희 식당은 휴무일이 없습니다.',6);
insert into restaurant_qna (rq_no,rq_question,rq_answer,restaurant_no) values (rq_no_seq.nextval,'빠르게 갈 수 있는 교통편이 있나요?','중문관광단지에 인접해있어 이동이 용이하고 중문일대는 픽업서비스도 준비되어있습니다. 자세한 사항은 매장으로 연락주세요.',6);
insert into restaurant_qna (rq_no,rq_question,rq_answer,restaurant_no) values (rq_no_seq.nextval,'지역화폐 사용가능한가요?','지류,카드 가능하며 제로페이도 사용가능합니다.',6);

insert into restaurant_qna (rq_no,rq_question,rq_answer,restaurant_no) values (rq_no_seq.nextval,'매장 영업시간은 어떻게되나요?','오전 7시부터 오후 11시까지 영업합니다.',7);
insert into restaurant_qna (rq_no,rq_question,rq_answer,restaurant_no) values (rq_no_seq.nextval,'휴무일이 언제인가요?','저희 식당은 연중무휴 입니다.',7);
insert into restaurant_qna (rq_no,rq_question,rq_answer,restaurant_no) values (rq_no_seq.nextval,'반려동물 동반 가능한가요?','반려동물은 동반이 가능하나 애견 케이지 지참시에만 가능합니다.',7);

insert into restaurant_qna (rq_no,rq_question,rq_answer,restaurant_no) values (rq_no_seq.nextval,'매장 영업시간은 어떻게되나요?','오전 10시부터 오후 9시까지 영업합니다. 쉬는시간은 오후 2시30분부터 오후 5시까지 입니다.',8);
insert into restaurant_qna (rq_no,rq_question,rq_answer,restaurant_no) values (rq_no_seq.nextval,'휴무일이 언제인가요?','매달 첫번째 세번째 수요일이 정기휴무 입니다.',8);

insert into restaurant_qna (rq_no,rq_question,rq_answer,restaurant_no) values (rq_no_seq.nextval,'매장 영업시간은 어떻게되나요?','오전 9시부터 오후 8시까지 입니다. 마지막 주문은 오후 7시 40분까지 입니다.',9);
insert into restaurant_qna (rq_no,rq_question,rq_answer,restaurant_no) values (rq_no_seq.nextval,'휴무일이 언제인가요?','저희 식당은 연중무휴 입니다.',9);
insert into restaurant_qna (rq_no,rq_question,rq_answer,restaurant_no) values (rq_no_seq.nextval,'반려동물 동반 가능한가요?','반려동물 동반이 가능한 펫 친화 카페입니다. 견종 크기상관없이 리드줄은 필수입니다. 단, 가방과 케이지 이용시 리드줄 없이도 이용가능합니다.',9);
insert into restaurant_qna (rq_no,rq_question,rq_answer,restaurant_no) values (rq_no_seq.nextval,'주차공간이 충분한가요?','카페 앞으로 약 50대이상 전용주차공간이 마련되어 있습니다. 주문시 차량번호를 꼭 말씀해주세요. 차량등록시 매장영업종료까지 무료주차 가능하나 카페를 이용하지않고 주차할 시 주차요금이 발생할 수 있습니다.',9);

insert into restaurant_qna (rq_no,rq_question,rq_answer,restaurant_no) values (rq_no_seq.nextval,'매장 영업시간은 어떻게되나요?','오전 9시부터 오후 8시까지 입니다. 제품 품절시 조기마감 될 수 있습니다.',10);
insert into restaurant_qna (rq_no,rq_question,rq_answer,restaurant_no) values (rq_no_seq.nextval,'휴무일이 언제인가요?','저희 카페는 연중무휴 입니다.',10);
insert into restaurant_qna (rq_no,rq_question,rq_answer,restaurant_no) values (rq_no_seq.nextval,'주차공간이 충분한가요?','우무 매장앞은 주정차 단속구간입니다. 주차시 과태료가 부과됩니다. 매장 근처 주차장을 확인하시고 방문해주시기 바랍니다. 도보 3분이내에 공영주차장이 있습니다.',10);
insert into restaurant_qna (rq_no,rq_question,rq_answer,restaurant_no) values (rq_no_seq.nextval,'냉장보관하면 몇일까지 가능한가요?','저희 제품에는 방부제,보존제가 들어있지않아서 구입 즉시 드시는것을 권장합니다. 보냉백 포장을 하시면 최대 5시간까지 보관가능합니다. 상온에 오래 방치될 경우 맛과 모양이 변질될 수 있습니다.',10);

-- restaurant booking
insert into restaurant_booking (rb_no, restaurant_no, user_no, rb_name, rb_phone, rb_persons, rb_date, rb_time)
values (rb_no_seq.nextval, 1, 1, 'aaaa', '010-1111-1111', 2, TO_DATE('2024-01-25', 'yyyy-MM-dd'), '1시');

insert into restaurant_booking (rb_no, restaurant_no, user_no, rb_name, rb_phone, rb_persons, rb_date, rb_time)
values (rb_no_seq.nextval, 1, 1, 'aaaa', '010-1111-1111', 2, sysdate, '1시');

insert into restaurant_booking (rb_no, restaurant_no, user_no, rb_name, rb_phone, rb_persons, rb_date, rb_time)
values (rb_no_seq.nextval, 1, 2, 'bbbb', '010-1111-1111', 3, sysdate, '2시');

insert into restaurant_booking (rb_no, restaurant_no, user_no, rb_name, rb_phone, rb_persons, rb_date, rb_time)
values (rb_no_seq.nextval, 1, 3, 'cccc', '010-1111-1111', 4, sysdate, '3시');

insert into restaurant_booking (rb_no, restaurant_no, user_no, rb_name, rb_phone, rb_persons, rb_date, rb_time)
values (rb_no_seq.nextval, 1, 4, 'dddd', '010-1111-1111', 2, sysdate, '4시');

insert into restaurant_booking (rb_no, restaurant_no, user_no, rb_name, rb_phone, rb_persons, rb_date, rb_time)
values (rb_no_seq.nextval, 1, 5, 'eeee', '010-1111-1111', 3, sysdate, '5시');

insert into restaurant_booking (rb_no, restaurant_no, user_no, rb_name, rb_phone, rb_persons, rb_date, rb_time)
values (rb_no_seq.nextval, 2, 1, 'aaaa', '010-1111-1111', 2, sysdate, '1시');

insert into restaurant_booking (rb_no, restaurant_no, user_no, rb_name, rb_phone, rb_persons, rb_date, rb_time)
values (rb_no_seq.nextval, 2, 2, 'bbbb', '010-1111-1111', 3, sysdate, '2시');

insert into restaurant_booking (rb_no, restaurant_no, user_no, rb_name, rb_phone, rb_persons, rb_date, rb_time)
values (rb_no_seq.nextval, 2, 3, 'cccc', '010-1111-1111', 4, sysdate, '3시');

insert into restaurant_booking (rb_no, restaurant_no, user_no, rb_name, rb_phone, rb_persons, rb_date, rb_time)
values (rb_no_seq.nextval, 2, 4, 'dddd', '010-1111-1111', 2, sysdate, '4시');

insert into restaurant_booking (rb_no, restaurant_no, user_no, rb_name, rb_phone, rb_persons, rb_date, rb_time)
values (rb_no_seq.nextval, 2, 5, 'eeee', '010-1111-1111', 3, sysdate, '5시');


-- restaurant category
insert into restaurant_category (rc_no, rc_name) values (rc_no_seq.nextval, '돈가스');
insert into restaurant_category (rc_no, rc_name) values (rc_no_seq.nextval, '피자');
insert into restaurant_category (rc_no, rc_name) values (rc_no_seq.nextval, '국수');
insert into restaurant_category (rc_no, rc_name) values (rc_no_seq.nextval, '육류, 고기요리');
insert into restaurant_category (rc_no, rc_name) values (rc_no_seq.nextval, '생선회');
insert into restaurant_category (rc_no, rc_name) values (rc_no_seq.nextval, '해물, 생선요리');
insert into restaurant_category (rc_no, rc_name) values (rc_no_seq.nextval, '카페, 디저트');
insert into restaurant_category (rc_no, rc_name) values (rc_no_seq.nextval, '해장국');
insert into restaurant_category (rc_no, rc_name) values (rc_no_seq.nextval, '백반, 가정식');
insert into restaurant_category (rc_no, rc_name) values (rc_no_seq.nextval, '김밥');

-- restaurant category item
insert into restaurant_category_item (rci_no, restaurant_no, rc_no) values (rci_no_seq.nextval, 1, 6);
insert into restaurant_category_item (rci_no, restaurant_no, rc_no) values (rci_no_seq.nextval, 2, 1);
insert into restaurant_category_item (rci_no, restaurant_no, rc_no) values (rci_no_seq.nextval, 3, 2);
insert into restaurant_category_item (rci_no, restaurant_no, rc_no) values (rci_no_seq.nextval, 4, 3);
insert into restaurant_category_item (rci_no, restaurant_no, rc_no) values (rci_no_seq.nextval, 5, 10);
insert into restaurant_category_item (rci_no, restaurant_no, rc_no) values (rci_no_seq.nextval, 6, 4);
insert into restaurant_category_item (rci_no, restaurant_no, rc_no) values (rci_no_seq.nextval, 7, 5);
insert into restaurant_category_item (rci_no, restaurant_no, rc_no) values (rci_no_seq.nextval, 8, 6);
insert into restaurant_category_item (rci_no, restaurant_no, rc_no) values (rci_no_seq.nextval, 9, 7);
insert into restaurant_category_item (rci_no, restaurant_no, rc_no) values (rci_no_seq.nextval, 10, 7);

-- restaurant menu
insert into restaurant_menu (rm_no, rm_name, rm_price, restaurant_no, rm_image) values (rm_no_seq.nextval, '갈치조림', 30000, 1, 'img.jpg');
insert into restaurant_menu (rm_no, rm_name, rm_price, restaurant_no, rm_image) values (rm_no_seq.nextval, '돈가스', 10000, 2, 'img.jpg');
insert into restaurant_menu (rm_no, rm_name, rm_price, restaurant_no, rm_image) values (rm_no_seq.nextval, '피자', 20000, 3, 'img.jpg');
insert into restaurant_menu (rm_no, rm_name, rm_price, restaurant_no, rm_image) values (rm_no_seq.nextval, '국수', 8000, 4, 'img.jpg');
insert into restaurant_menu (rm_no, rm_name, rm_price, restaurant_no, rm_image) values (rm_no_seq.nextval, '보말죽', 15000, 5, 'img.jpg');
insert into restaurant_menu (rm_no, rm_name, rm_price, restaurant_no, rm_image) values (rm_no_seq.nextval, '흑돼지', 15000, 6, 'img.jpg');
insert into restaurant_menu (rm_no, rm_name, rm_price, restaurant_no, rm_image) values (rm_no_seq.nextval, '딱새우회', 30000, 7, 'img.jpg');
insert into restaurant_menu (rm_no, rm_name, rm_price, restaurant_no, rm_image) values (rm_no_seq.nextval, '갈치구이', 40000, 8, 'img.jpg');
insert into restaurant_menu (rm_no, rm_name, rm_price, restaurant_no, rm_image) values (rm_no_seq.nextval, '에스프레소', 6000, 9, 'img.jpg');
insert into restaurant_menu (rm_no, rm_name, rm_price, restaurant_no, rm_image) values (rm_no_seq.nextval, '푸딩', 6000, 10, 'img.jpg');

-- restaurant review
insert into restaurant_review (rr_no, restaurant_no, user_no, rr_content, rr_date, rr_star)
values (rr_no_seq.nextval, 1, 1, '좋아요', sysdate, 0.0);

insert into restaurant_review (rr_no, restaurant_no, user_no, rr_content, rr_date, rr_star)
values (rr_no_seq.nextval, 1, 2, '좋아요', sysdate, 1.0);

insert into restaurant_review (rr_no, restaurant_no, user_no, rr_content, rr_date, rr_star)
values (rr_no_seq.nextval, 1, 3, '좋아요', sysdate, 2.0);

insert into restaurant_review (rr_no, restaurant_no, user_no, rr_content, rr_date, rr_star)
values (rr_no_seq.nextval, 1, 4, '좋아요', sysdate, 3.0);

insert into restaurant_review (rr_no, restaurant_no, user_no, rr_content, rr_date, rr_star)
values (rr_no_seq.nextval, 1, 5, '좋아요', sysdate, 4.0);

insert into restaurant_review (rr_no, restaurant_no, user_no, rr_content, rr_date, rr_star)
values (rr_no_seq.nextval, 2, 1, '별로예요', sysdate, 0.0);

insert into restaurant_review (rr_no, restaurant_no, user_no, rr_content, rr_date, rr_star)
values (rr_no_seq.nextval, 2, 2, '별로예요', sysdate, 1.0);

insert into restaurant_review (rr_no, restaurant_no, user_no, rr_content, rr_date, rr_star)
values (rr_no_seq.nextval, 2, 3, '별로예요', sysdate, 2.0);

insert into restaurant_review (rr_no, restaurant_no, user_no, rr_content, rr_date, rr_star)
values (rr_no_seq.nextval, 2, 4, '별로예요', sysdate, 3.0);

insert into restaurant_review (rr_no, restaurant_no, user_no, rr_content, rr_date, rr_star)
values (rr_no_seq.nextval, 2, 5, '별로예요', sysdate, 4.0);

-- restaurant Image
insert into restaurant_image(image_no,image_name,restaurant_no) values (restaurant_image_seq.nextval,'Aewol1.jpg',1);
insert into restaurant_image(image_no,image_name,restaurant_no) values (restaurant_image_seq.nextval,'Aewol2.jpg',1);
insert into restaurant_image(image_no,image_name,restaurant_no) values (restaurant_image_seq.nextval,'Aewol3.jpg',1);
insert into restaurant_image(image_no,image_name,restaurant_no) values (restaurant_image_seq.nextval,'Aewol4.jpg',1);

insert into restaurant_image(image_no,image_name,restaurant_no) values (restaurant_image_seq.nextval,'yeondon1.jpg',2);
insert into restaurant_image(image_no,image_name,restaurant_no) values (restaurant_image_seq.nextval,'yeondon2.jpg',2);
insert into restaurant_image(image_no,image_name,restaurant_no) values (restaurant_image_seq.nextval,'yeondon3.jpg',2);
insert into restaurant_image(image_no,image_name,restaurant_no) values (restaurant_image_seq.nextval,'yeondon4.jpg',2);

insert into restaurant_image(image_no,image_name,restaurant_no) values (restaurant_image_seq.nextval,'gojawalhwadeokpija1.jpg',3);
insert into restaurant_image(image_no,image_name,restaurant_no) values (restaurant_image_seq.nextval,'gojawalhwadeokpija2.jpg',3);
insert into restaurant_image(image_no,image_name,restaurant_no) values (restaurant_image_seq.nextval,'gojawalhwadeokpija3.jpg',3);
insert into restaurant_image(image_no,image_name,restaurant_no) values (restaurant_image_seq.nextval,'gojawalhwadeokpija4.jpg',3);

insert into restaurant_image(image_no,image_name,restaurant_no) values (restaurant_image_seq.nextval,'jamaeguksu1.jpg',4);
insert into restaurant_image(image_no,image_name,restaurant_no) values (restaurant_image_seq.nextval,'jamaeguksu2.jpg',4);
insert into restaurant_image(image_no,image_name,restaurant_no) values (restaurant_image_seq.nextval,'jamaeguksu3.jpg',4);
insert into restaurant_image(image_no,image_name,restaurant_no) values (restaurant_image_seq.nextval,'jamaeguksu4.jpg',4);

insert into restaurant_image(image_no,image_name,restaurant_no) values (restaurant_image_seq.nextval,'haenyeogimbap1.jpg',5);
insert into restaurant_image(image_no,image_name,restaurant_no) values (restaurant_image_seq.nextval,'haenyeogimbap2.jpg',5);
insert into restaurant_image(image_no,image_name,restaurant_no) values (restaurant_image_seq.nextval,'haenyeogimbap3.jpg',5);
insert into restaurant_image(image_no,image_name,restaurant_no) values (restaurant_image_seq.nextval,'haenyeogimbap4.jpg',5);

insert into restaurant_image(image_no,image_name,restaurant_no) values (restaurant_image_seq.nextval,'doldamheukdwaeji1.jpg',6);
insert into restaurant_image(image_no,image_name,restaurant_no) values (restaurant_image_seq.nextval,'doldamheukdwaeji2.jpg',6);
insert into restaurant_image(image_no,image_name,restaurant_no) values (restaurant_image_seq.nextval,'doldamheukdwaeji3.jpg',6);
insert into restaurant_image(image_no,image_name,restaurant_no) values (restaurant_image_seq.nextval,'doldamheukdwaeji4.jpg',6);

insert into restaurant_image(image_no,image_name,restaurant_no) values (restaurant_image_seq.nextval,'asihoesjip1.jpg',7);
insert into restaurant_image(image_no,image_name,restaurant_no) values (restaurant_image_seq.nextval,'asihoesjip2.jpg',7);
insert into restaurant_image(image_no,image_name,restaurant_no) values (restaurant_image_seq.nextval,'asihoesjip3.jpg',7);
insert into restaurant_image(image_no,image_name,restaurant_no) values (restaurant_image_seq.nextval,'asihoesjip4.jpg',7);

insert into restaurant_image(image_no,image_name,restaurant_no) values (restaurant_image_seq.nextval,'jegaryang1.jpg',8);
insert into restaurant_image(image_no,image_name,restaurant_no) values (restaurant_image_seq.nextval,'jegaryang2.jpg',8);
insert into restaurant_image(image_no,image_name,restaurant_no) values (restaurant_image_seq.nextval,'jegaryang3.jpg',8);
insert into restaurant_image(image_no,image_name,restaurant_no) values (restaurant_image_seq.nextval,'jegaryang4.jpg',8);

insert into restaurant_image(image_no,image_name,restaurant_no) values (restaurant_image_seq.nextval,'reiji peompeu1.jpg',9);
insert into restaurant_image(image_no,image_name,restaurant_no) values (restaurant_image_seq.nextval,'reiji peompeu2.jpg',9);
insert into restaurant_image(image_no,image_name,restaurant_no) values (restaurant_image_seq.nextval,'reiji peompeu3.jpg',9);
insert into restaurant_image(image_no,image_name,restaurant_no) values (restaurant_image_seq.nextval,'reiji peompeu4.jpg',9);

insert into restaurant_image(image_no,image_name,restaurant_no) values (restaurant_image_seq.nextval,'umu1.jpg',10);
insert into restaurant_image(image_no,image_name,restaurant_no) values (restaurant_image_seq.nextval,'umu2.jpg',10);
insert into restaurant_image(image_no,image_name,restaurant_no) values (restaurant_image_seq.nextval,'umu3.jpg',10);
insert into restaurant_image(image_no,image_name,restaurant_no) values (restaurant_image_seq.nextval,'umu4.jpg',10);

--restaurantAmenity
insert into restaurant_amenity(restaurant_amenity.ra_no,restaurant_amenity.ra_check,restaurant_amenity.restaurant_no) values (ra_no_seq.nextval,0,1);
insert into restaurant_amenity(restaurant_amenity.ra_no,restaurant_amenity.ra_check,restaurant_amenity.restaurant_no) values (ra_no_seq.nextval,1,1);
insert into restaurant_amenity(restaurant_amenity.ra_no,restaurant_amenity.ra_check,restaurant_amenity.restaurant_no) values (ra_no_seq.nextval,1,1);
insert into restaurant_amenity(restaurant_amenity.ra_no,restaurant_amenity.ra_check,restaurant_amenity.restaurant_no) values (ra_no_seq.nextval,1,1);
insert into restaurant_amenity(restaurant_amenity.ra_no,restaurant_amenity.ra_check,restaurant_amenity.restaurant_no) values (ra_no_seq.nextval,1,1);
insert into restaurant_amenity(restaurant_amenity.ra_no,restaurant_amenity.ra_check,restaurant_amenity.restaurant_no) values (ra_no_seq.nextval,1,1);

insert into restaurant_amenity(restaurant_amenity.ra_no,restaurant_amenity.ra_check,restaurant_amenity.restaurant_no) values (ra_no_seq.nextval,0,2);
insert into restaurant_amenity(restaurant_amenity.ra_no,restaurant_amenity.ra_check,restaurant_amenity.restaurant_no) values (ra_no_seq.nextval,1,2);
insert into restaurant_amenity(restaurant_amenity.ra_no,restaurant_amenity.ra_check,restaurant_amenity.restaurant_no) values (ra_no_seq.nextval,1,2);
insert into restaurant_amenity(restaurant_amenity.ra_no,restaurant_amenity.ra_check,restaurant_amenity.restaurant_no) values (ra_no_seq.nextval,1,2);
insert into restaurant_amenity(restaurant_amenity.ra_no,restaurant_amenity.ra_check,restaurant_amenity.restaurant_no) values (ra_no_seq.nextval,1,2);
insert into restaurant_amenity(restaurant_amenity.ra_no,restaurant_amenity.ra_check,restaurant_amenity.restaurant_no) values (ra_no_seq.nextval,1,2);

insert into restaurant_amenity(restaurant_amenity.ra_no,restaurant_amenity.ra_check,restaurant_amenity.restaurant_no) values (ra_no_seq.nextval,0,3);
insert into restaurant_amenity(restaurant_amenity.ra_no,restaurant_amenity.ra_check,restaurant_amenity.restaurant_no) values (ra_no_seq.nextval,1,3);
insert into restaurant_amenity(restaurant_amenity.ra_no,restaurant_amenity.ra_check,restaurant_amenity.restaurant_no) values (ra_no_seq.nextval,1,3);
insert into restaurant_amenity(restaurant_amenity.ra_no,restaurant_amenity.ra_check,restaurant_amenity.restaurant_no) values (ra_no_seq.nextval,1,3);
insert into restaurant_amenity(restaurant_amenity.ra_no,restaurant_amenity.ra_check,restaurant_amenity.restaurant_no) values (ra_no_seq.nextval,1,3);
insert into restaurant_amenity(restaurant_amenity.ra_no,restaurant_amenity.ra_check,restaurant_amenity.restaurant_no) values (ra_no_seq.nextval,1,3);

insert into restaurant_amenity(restaurant_amenity.ra_no,restaurant_amenity.ra_check,restaurant_amenity.restaurant_no) values (ra_no_seq.nextval,0,4);
insert into restaurant_amenity(restaurant_amenity.ra_no,restaurant_amenity.ra_check,restaurant_amenity.restaurant_no) values (ra_no_seq.nextval,1,4);
insert into restaurant_amenity(restaurant_amenity.ra_no,restaurant_amenity.ra_check,restaurant_amenity.restaurant_no) values (ra_no_seq.nextval,1,4);
insert into restaurant_amenity(restaurant_amenity.ra_no,restaurant_amenity.ra_check,restaurant_amenity.restaurant_no) values (ra_no_seq.nextval,1,4);
insert into restaurant_amenity(restaurant_amenity.ra_no,restaurant_amenity.ra_check,restaurant_amenity.restaurant_no) values (ra_no_seq.nextval,1,4);
insert into restaurant_amenity(restaurant_amenity.ra_no,restaurant_amenity.ra_check,restaurant_amenity.restaurant_no) values (ra_no_seq.nextval,1,4);

insert into restaurant_amenity(restaurant_amenity.ra_no,restaurant_amenity.ra_check,restaurant_amenity.restaurant_no) values (ra_no_seq.nextval,0,5);
insert into restaurant_amenity(restaurant_amenity.ra_no,restaurant_amenity.ra_check,restaurant_amenity.restaurant_no) values (ra_no_seq.nextval,1,5);
insert into restaurant_amenity(restaurant_amenity.ra_no,restaurant_amenity.ra_check,restaurant_amenity.restaurant_no) values (ra_no_seq.nextval,1,5);
insert into restaurant_amenity(restaurant_amenity.ra_no,restaurant_amenity.ra_check,restaurant_amenity.restaurant_no) values (ra_no_seq.nextval,1,5);
insert into restaurant_amenity(restaurant_amenity.ra_no,restaurant_amenity.ra_check,restaurant_amenity.restaurant_no) values (ra_no_seq.nextval,1,5);
insert into restaurant_amenity(restaurant_amenity.ra_no,restaurant_amenity.ra_check,restaurant_amenity.restaurant_no) values (ra_no_seq.nextval,1,5);

insert into restaurant_amenity(restaurant_amenity.ra_no,restaurant_amenity.ra_check,restaurant_amenity.restaurant_no) values (ra_no_seq.nextval,0,6);
insert into restaurant_amenity(restaurant_amenity.ra_no,restaurant_amenity.ra_check,restaurant_amenity.restaurant_no) values (ra_no_seq.nextval,1,6);
insert into restaurant_amenity(restaurant_amenity.ra_no,restaurant_amenity.ra_check,restaurant_amenity.restaurant_no) values (ra_no_seq.nextval,1,6);
insert into restaurant_amenity(restaurant_amenity.ra_no,restaurant_amenity.ra_check,restaurant_amenity.restaurant_no) values (ra_no_seq.nextval,1,6);
insert into restaurant_amenity(restaurant_amenity.ra_no,restaurant_amenity.ra_check,restaurant_amenity.restaurant_no) values (ra_no_seq.nextval,1,6);
insert into restaurant_amenity(restaurant_amenity.ra_no,restaurant_amenity.ra_check,restaurant_amenity.restaurant_no) values (ra_no_seq.nextval,1,6);

insert into restaurant_amenity(restaurant_amenity.ra_no,restaurant_amenity.ra_check,restaurant_amenity.restaurant_no) values (ra_no_seq.nextval,0,7);
insert into restaurant_amenity(restaurant_amenity.ra_no,restaurant_amenity.ra_check,restaurant_amenity.restaurant_no) values (ra_no_seq.nextval,1,7);
insert into restaurant_amenity(restaurant_amenity.ra_no,restaurant_amenity.ra_check,restaurant_amenity.restaurant_no) values (ra_no_seq.nextval,1,7);
insert into restaurant_amenity(restaurant_amenity.ra_no,restaurant_amenity.ra_check,restaurant_amenity.restaurant_no) values (ra_no_seq.nextval,1,7);
insert into restaurant_amenity(restaurant_amenity.ra_no,restaurant_amenity.ra_check,restaurant_amenity.restaurant_no) values (ra_no_seq.nextval,1,7);
insert into restaurant_amenity(restaurant_amenity.ra_no,restaurant_amenity.ra_check,restaurant_amenity.restaurant_no) values (ra_no_seq.nextval,1,7);

insert into restaurant_amenity(restaurant_amenity.ra_no,restaurant_amenity.ra_check,restaurant_amenity.restaurant_no) values (ra_no_seq.nextval,0,8);
insert into restaurant_amenity(restaurant_amenity.ra_no,restaurant_amenity.ra_check,restaurant_amenity.restaurant_no) values (ra_no_seq.nextval,1,8);
insert into restaurant_amenity(restaurant_amenity.ra_no,restaurant_amenity.ra_check,restaurant_amenity.restaurant_no) values (ra_no_seq.nextval,1,8);
insert into restaurant_amenity(restaurant_amenity.ra_no,restaurant_amenity.ra_check,restaurant_amenity.restaurant_no) values (ra_no_seq.nextval,1,8);
insert into restaurant_amenity(restaurant_amenity.ra_no,restaurant_amenity.ra_check,restaurant_amenity.restaurant_no) values (ra_no_seq.nextval,1,8);
insert into restaurant_amenity(restaurant_amenity.ra_no,restaurant_amenity.ra_check,restaurant_amenity.restaurant_no) values (ra_no_seq.nextval,1,8);

insert into restaurant_amenity(restaurant_amenity.ra_no,restaurant_amenity.ra_check,restaurant_amenity.restaurant_no) values (ra_no_seq.nextval,0,9);
insert into restaurant_amenity(restaurant_amenity.ra_no,restaurant_amenity.ra_check,restaurant_amenity.restaurant_no) values (ra_no_seq.nextval,1,9);
insert into restaurant_amenity(restaurant_amenity.ra_no,restaurant_amenity.ra_check,restaurant_amenity.restaurant_no) values (ra_no_seq.nextval,1,9);
insert into restaurant_amenity(restaurant_amenity.ra_no,restaurant_amenity.ra_check,restaurant_amenity.restaurant_no) values (ra_no_seq.nextval,1,9);
insert into restaurant_amenity(restaurant_amenity.ra_no,restaurant_amenity.ra_check,restaurant_amenity.restaurant_no) values (ra_no_seq.nextval,1,9);
insert into restaurant_amenity(restaurant_amenity.ra_no,restaurant_amenity.ra_check,restaurant_amenity.restaurant_no) values (ra_no_seq.nextval,1,9);

insert into restaurant_amenity(restaurant_amenity.ra_no,restaurant_amenity.ra_check,restaurant_amenity.restaurant_no) values (ra_no_seq.nextval,0,10);
insert into restaurant_amenity(restaurant_amenity.ra_no,restaurant_amenity.ra_check,restaurant_amenity.restaurant_no) values (ra_no_seq.nextval,1,10);
insert into restaurant_amenity(restaurant_amenity.ra_no,restaurant_amenity.ra_check,restaurant_amenity.restaurant_no) values (ra_no_seq.nextval,1,10);
insert into restaurant_amenity(restaurant_amenity.ra_no,restaurant_amenity.ra_check,restaurant_amenity.restaurant_no) values (ra_no_seq.nextval,1,10);
insert into restaurant_amenity(restaurant_amenity.ra_no,restaurant_amenity.ra_check,restaurant_amenity.restaurant_no) values (ra_no_seq.nextval,1,10);
insert into restaurant_amenity(restaurant_amenity.ra_no,restaurant_amenity.ra_check,restaurant_amenity.restaurant_no) values (ra_no_seq.nextval,1,10);

-- wish
insert into wish (wish_no, user_no, attraction_no, hotel_no, restaurant_no, wish_category) values (wish_no_seq.nextval, 1, 1, null, null, '명소');
insert into wish (wish_no, user_no, attraction_no, hotel_no, restaurant_no, wish_category) values (wish_no_seq.nextval, 1, 2, null, null, '명소');
insert into wish (wish_no, user_no, attraction_no, hotel_no, restaurant_no, wish_category) values (wish_no_seq.nextval, 1, null, 1, null, '호텔');
insert into wish (wish_no, user_no, attraction_no, hotel_no, restaurant_no, wish_category) values (wish_no_seq.nextval, 1, null, 2, null, '호텔');
insert into wish (wish_no, user_no, attraction_no, hotel_no, restaurant_no, wish_category) values (wish_no_seq.nextval, 1, null, null, 1, '맛집');
insert into wish (wish_no, user_no, attraction_no, hotel_no, restaurant_no, wish_category) values (wish_no_seq.nextval, 2, 1, null, null, '명소');
insert into wish (wish_no, user_no, attraction_no, hotel_no, restaurant_no, wish_category) values (wish_no_seq.nextval, 2, 2, null, null, '명소');
insert into wish (wish_no, user_no, attraction_no, hotel_no, restaurant_no, wish_category) values (wish_no_seq.nextval, 2, null, 1, null, '호텔');
insert into wish (wish_no, user_no, attraction_no, hotel_no, restaurant_no, wish_category) values (wish_no_seq.nextval, 2, null, 2, null, '호텔');
insert into wish (wish_no, user_no, attraction_no, hotel_no, restaurant_no, wish_category) values (wish_no_seq.nextval, 2, null, null, 1, '맛집');