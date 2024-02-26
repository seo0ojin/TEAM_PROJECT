package com.jeju.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jeju.entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long>{
	
	// 호텔 이름 검색
	Page<Hotel> findByHotelNameLike(String hotelName, Pageable pageable);
	List<Hotel> findByHotelNameLike(String hotelName);
	
	// 지역명으로 검색
	Page<Hotel> findByHotelLocalLike(String hotelLocal, Pageable pageable);
	List<Hotel> findByHotelLocalLike(String hotelLocal);
	
	// 별점 높은순 정렬
	List<Hotel> findAllByOrderByHotelStarDesc();
	
	// 가격 높은순 정렬
	List<Hotel> findAllByOrderByHotelPriceDesc();
	
	// 가격 낮은순 정렬
	List<Hotel> findAllByOrderByHotelPriceAsc();
	
	// 리뷰 많은순 정렬
	@Query(value = "SELECT h.hotel_No, h.hotel_name, h.hotel_price, h.hotel_star, h.hotel_desc, h.hotel_local,h.hotel_map FROM hotel h LEFT JOIN hotel_review hr ON h.hotel_No = hr.hotel_No GROUP BY h.hotel_No, h.hotel_name, h.hotel_price, h.hotel_star, h.hotel_desc, h.hotel_local,h.hotel_map ORDER BY COUNT(hr.hr_No) DESC", nativeQuery = true)
	List<Hotel> findHotelOrderByReviewCountDesc();
	
	// 예약 많은순 정렬 (인기순)
	@Query(value = "SELECT h.hotel_No, h.hotel_name, h.hotel_price, h.hotel_star, h.hotel_desc, h.hotel_local,h.hotel_map FROM hotel h LEFT JOIN hotel_booking hb ON h.hotel_No = hb.hotel_No GROUP BY h.hotel_No, h.hotel_name, h.hotel_price, h.hotel_star, h.hotel_desc, h.hotel_local,h.hotel_map ORDER BY COUNT(hb.hb_No) DESC", nativeQuery = true)
	List<Hotel> findHotelOrderByBookingCountDesc();
	
	// 카테고리 번호로 레스토랑 뽑기
	List<Hotel> findByHotelCategoryItemsHotelCategoryHcNo(Long hcNo);
	
	
	/*************** 이중 정렬 ****************/
	
	
	// 별점순 + 카테고리
	@Query(value = "select h.hotel_No, h.hotel_name, h.hotel_price, h.hotel_star, h.hotel_desc, h.hotel_local,h.hotel_map from hotel h join hotel_category_item hci on h.hotel_no = hci.hotel_no where hci.hc_no = ?1 group by h.hotel_no,h.hotel_name,h.hotel_local,h.hotel_desc,h.hotel_star,h.hotel_price,h.hotel_map ORDER BY h.hotel_star DESC", nativeQuery = true)
	public List<Hotel> findByCategoryNoOrderByStars(@Param("categoryNo") Long categoryNo);
	
	// 리뷰많은순 + 카테고리
	@Query(value = "select h.hotel_No, h.hotel_name, h.hotel_price, h.hotel_star, h.hotel_desc, h.hotel_local,h.hotel_map from hotel h left join hotel_review hr on h.hotel_no = hr.hotel_no join hotel_category_item hci on h.hotel_no = hci.hotel_no where hci.hc_no = ?1 group by h.hotel_no,h.hotel_name,h.hotel_local,h.hotel_desc,h.hotel_star,h.hotel_price,h.hotel_map ORDER BY COUNT(hr.hr_no) DESC", nativeQuery = true)
	public List<Hotel> findByCategoryNoOrderByReviewsDesc(@Param("categoryNo") Long categoryNo);

	// 예약많은순 + 카테고리
	@Query(value = "select h.hotel_No, h.hotel_name, h.hotel_price, h.hotel_star, h.hotel_desc, h.hotel_local,h.hotel_map from hotel h left join hotel_booking hb on h.hotel_no = hb.hotel_no join hotel_category_item hci on h.hotel_no = hci.hotel_no where hci.hc_no = ?1 group by h.hotel_no,h.hotel_name,h.hotel_local,h.hotel_desc,h.hotel_star,h.hotel_price,h.hotel_map ORDER BY COUNT(hb.hb_no) DESC", nativeQuery = true)
	public List<Hotel> findByCategoryNoOrderByBookingsDesc(@Param("categoryNo") Long categoryNo);

	// 가격높은순 + 카테고리
	@Query(value = "select h.hotel_No, h.hotel_name, h.hotel_price, h.hotel_star, h.hotel_desc, h.hotel_local,h.hotel_map from hotel h join hotel_category_item hci on h.hotel_no = hci.hotel_no where hci.hc_no = ?1 group by h.hotel_no,h.hotel_name,h.hotel_local,h.hotel_desc,h.hotel_star,h.hotel_price,h.hotel_map ORDER BY h.hotel_price DESC", nativeQuery = true)
	public List<Hotel> findByCategoryNoOrderByPriceDesc(@Param("categoryNo") Long categoryNo);

	// 가격낮은순 + 카테고리
	@Query(value = "select h.hotel_No, h.hotel_name, h.hotel_price, h.hotel_star, h.hotel_desc, h.hotel_local,h.hotel_map from hotel h join hotel_category_item hci on h.hotel_no = hci.hotel_no where hci.hc_no = ?1 group by h.hotel_no,h.hotel_name,h.hotel_local,h.hotel_desc,h.hotel_star,h.hotel_price,h.hotel_map ORDER BY h.hotel_price Asc", nativeQuery = true)
	public List<Hotel> findByCategoryNoOrderByPriceAsc(@Param("categoryNo") Long categoryNo);

	
	/*****************************************/
	
	
	
	/*************** 검색 + 카테고리 + 정렬 ****************/
	
	
	// 다른 테이블과 정렬
	// 검색 + 카테고리 + 예약 많은순(인기순)
	@Query(value = "SELECT h.hotel_No, h.hotel_name, h.hotel_price, h.hotel_star, h.hotel_desc, h.hotel_local,h.hotel_map FROM hotel h LEFT JOIN hotel_booking hb ON h.hotel_no = hb.hotel_no JOIN hotel_category_item hci ON h.hotel_no = hci.hotel_no WHERE hci.hc_no = ?1 and (h.hotel_name like '%'||?2||'%' or h.hotel_local like '%'||?2||'%') GROUP BY h.hotel_no, h.hotel_name, h.hotel_local, h.hotel_star,h.hotel_price, h.hotel_desc,h.hotel_map ORDER BY COUNT(hb.hb_no) DESC", nativeQuery = true)
	public List<Hotel> findHotelLikeHotelNameByCategoryNoOrderByBookingsDesc(Long categoryNo, String searchKeyword);

	// 검색 + 카테고리 + 리뷰 많은순
	@Query(value = "select h.hotel_No, h.hotel_name, h.hotel_price, h.hotel_star, h.hotel_desc, h.hotel_local,h.hotel_map from hotel h LEFT join hotel_review hr on h.hotel_no = hr.hotel_no join hotel_category_item hci on h.hotel_no = hci.hotel_no where hci.hc_no = ?1 and (h.hotel_name like '%'||?2||'%' or h.hotel_local like '%'||?2||'%') group by h.hotel_no, h.hotel_name, h.hotel_local,h.hotel_star,h.hotel_price,h.hotel_desc,h.hotel_map ORDER BY COUNT(hr.hr_no) DESC", nativeQuery = true)
	public List<Hotel> findHotelLikeHotelNameByCategoryNoOrderByReviewsDesc(Long categoryNo, String searchKeyword);

	
	// 같은 테이블에서 정렬
	// 검색 + 카테고리 + 별점순
	@Query(value = "select h.hotel_No, h.hotel_name, h.hotel_price, h.hotel_star, h.hotel_desc, h.hotel_local,h.hotel_map from hotel h join hotel_category_item hci on h.hotel_no = hci.hotel_no where hci.hc_no = ?1 and (h.hotel_name like '%'||?2||'%' or h.hotel_local like '%'||?2||'%') group by h.hotel_no,h.hotel_name,h.hotel_local,h.hotel_desc,h.hotel_star,h.hotel_price,h.hotel_map ORDER BY h.hotel_star DESC", nativeQuery = true)
	public List<Hotel> findHotelLikeHotelNameByCategoryNoOrderByStars(Long categoryNo, String searchKeyword);

	// 검색 + 카테고리 + 가격높은순
	@Query(value = "select h.hotel_No, h.hotel_name, h.hotel_price, h.hotel_star, h.hotel_desc, h.hotel_local,h.hotel_map from hotel h join hotel_category_item hci on h.hotel_no = hci.hotel_no where hci.hc_no = ?1 and (h.hotel_name like '%'||?2||'%' or h.hotel_local like '%'||?2||'%') group by h.hotel_no,h.hotel_name,h.hotel_local,h.hotel_desc,h.hotel_star,h.hotel_price,h.hotel_map ORDER BY h.hotel_price DESC", nativeQuery = true)
	public List<Hotel> findHotelLikeHotelNameByCategoryNoOrderByPriceDesc(Long categoryNo, String searchKeyword);

	// 검색 + 카테고리 + 가격낮은순
	@Query(value = "select h.hotel_No, h.hotel_name, h.hotel_price, h.hotel_star, h.hotel_desc, h.hotel_local,h.hotel_map from hotel h join hotel_category_item hci on h.hotel_no = hci.hotel_no where hci.hc_no = ?1 and (h.hotel_name like '%'||?2||'%' or h.hotel_local like '%'||?2||'%') group by h.hotel_no,h.hotel_name,h.hotel_local,h.hotel_desc,h.hotel_star,h.hotel_price,h.hotel_map ORDER BY h.hotel_price Asc", nativeQuery = true)
	public List<Hotel> findHotelLikeHotelNameByCategoryNoOrderByPriceAsc(Long categoryNo, String searchKeyword);

	
	/*****************************************************/
	
	
	
	
	/*************** 주소검색 + 카테고리 + 정렬 ****************/
	
	/*
	// 다른 테이블과 정렬
	// 주소검색 + 카테고리 + 예약 많은순(인기순)
	@Query(value = "SELECT h.* FROM hotel h LEFT JOIN hotel_booking hb ON h.hotel_no = hb.hotel_no JOIN hotel_category_item hci ON h.hotel_no = hci.hotel_no WHERE hci.hc_no = ?1 and h.hotel_local like '%'||?2||'%' GROUP BY h.hotel_no, h.hotel_name, h.hotel_local, h.hotel_star,h.hotel_price, h.hotel_desc ORDER BY COUNT(hb.hb_no) DESC", nativeQuery = true)
	public List<Hotel> findHotelLikeHotelLocalByCategoryNoOrderByBookingsDesc(Long categoryNo, String searchKeyword);

	// 주소검색 + 카테고리 + 리뷰 많은순
	@Query(value = "select h.* from hotel h LEFT join hotel_review hr on h.hotel_no = hr.hotel_no join hotel_category_item hci on h.hotel_no = hci.hotel_no where hci.hc_no = ?1 and h.hotel_local like '%'||?2||'%' group by h.hotel_no, h.hotel_name, h.hotel_local,h.hotel_star,h.hotel_price,h.hotel_desc ORDER BY COUNT(hr.hr_no) DESC", nativeQuery = true)
	public List<Hotel> findHotelLikeHotelLocalByCategoryNoOrderByReviewsDesc(Long categoryNo, String searchKeyword);

	
	// 같은 테이블에서 정렬
	// 주소검색 + 카테고리 + 별점순
	@Query(value = "select h.* from hotel h join hotel_category_item hci on h.hotel_no = hci.hotel_no where hci.hc_no = ?1 and h.hotel_local like '%'||?2||'%' group by h.hotel_no,h.hotel_name,h.hotel_local,h.hotel_desc,h.hotel_star,h.hotel_price ORDER BY h.hotel_star DESC", nativeQuery = true)
	public List<Hotel> findHotelLikeHotelLocalByCategoryNoOrderByStars(Long categoryNo, String searchKeyword);

	// 주소검색 + 카테고리 + 가격높은순
	@Query(value = "select h.* from hotel h join hotel_category_item hci on h.hotel_no = hci.hotel_no where hci.hc_no = ?1 and h.hotel_local like '%'||?2||'%' group by h.hotel_no,h.hotel_name,h.hotel_local,h.hotel_desc,h.hotel_star,h.hotel_price ORDER BY h.hotel_price DESC", nativeQuery = true)
	public List<Hotel> findHotelLikeHotelLocalByCategoryNoOrderByPriceDesc(Long categoryNo, String searchKeyword);

	// 주소검색 + 카테고리 + 가격낮은순
	@Query(value = "select h.* from hotel h join hotel_category_item hci on h.hotel_no = hci.hotel_no where hci.hc_no = ?1 and h.hotel_local like '%'||?2||'%' group by h.hotel_no,h.hotel_name,h.hotel_local,h.hotel_desc,h.hotel_star,h.hotel_price ORDER BY h.hotel_price Asc", nativeQuery = true)
	public List<Hotel> findHotelLikeHotelLocalByCategoryNoOrderByPriceAsc(Long categoryNo, String searchKeyword);
	*/
	
	/*****************************************************/
	
	
	
	/******************* 이름검색 + 정렬 ********************/
	
	
	// 다른 테이블과 정렬
	// 이름검색 + 예약 많은순
	@Query(value = "SELECT h.hotel_No, h.hotel_name, h.hotel_price, h.hotel_star, h.hotel_desc, h.hotel_local,h.hotel_map FROM hotel h LEFT JOIN hotel_booking hb ON h.hotel_No = hb.hotel_No where h.hotel_name like '%'||?1||'%' or h.hotel_local like '%'||?1||'%' GROUP BY h.hotel_no,h.hotel_name,h.hotel_local,h.hotel_desc,h.hotel_star,h.hotel_price,h.hotel_map ORDER BY COUNT(hb.hb_No) DESC", nativeQuery = true)
	public List<Hotel> findHotelLikeHotelNameByBookingCountDesc(String searchKeyword);
	
	// 이름검색 + 리뷰 많은순
	@Query(value = "SELECT h.hotel_No, h.hotel_name, h.hotel_price, h.hotel_star, h.hotel_desc, h.hotel_local,h.hotel_map FROM hotel h LEFT JOIN hotel_review hr ON h.hotel_No = hr.hotel_No where h.hotel_name like '%'||?1||'%' or h.hotel_local like '%'||?1||'%' GROUP BY h.hotel_no,h.hotel_name,h.hotel_local,h.hotel_desc,h.hotel_star,h.hotel_price,h.hotel_map ORDER BY COUNT(hr.hr_No) DESC", nativeQuery = true)
	public List<Hotel> findHotelLikeHotelNameOrderByReviewCountDesc(String searchKeyword);
	
	
	// 같은 테이블에서 정렬
	// 이름검색 + 별점 많은순
	@Query(value = "SELECT h.hotel_No, h.hotel_name, h.hotel_price, h.hotel_star, h.hotel_desc, h.hotel_local,h.hotel_map FROM hotel h where h.hotel_name like '%'||?1||'%' or h.hotel_local like '%'||?1||'%' GROUP BY h.hotel_no,h.hotel_name,h.hotel_local,h.hotel_desc,h.hotel_star,h.hotel_price,h.hotel_map ORDER BY h.hotel_star DESC", nativeQuery = true)
	public List<Hotel> findHotelLikeHotelNameByOrderByHotelStarDesc(String searchKeyword);
	
	// 이름검색 + 가격높은순
	@Query(value = "SELECT h.hotel_No, h.hotel_name, h.hotel_price, h.hotel_star, h.hotel_desc, h.hotel_local,h.hotel_map FROM hotel h where h.hotel_name like '%'||?1||'%' or h.hotel_local like '%'||?1||'%' GROUP BY h.hotel_no,h.hotel_name,h.hotel_local,h.hotel_desc,h.hotel_star,h.hotel_price,h.hotel_map ORDER BY h.hotel_price DESC", nativeQuery = true)
	public List<Hotel> findHotelLikeHotelNameByOrderByHotelPriceDesc(String searchKeyword);
	
	// 이름검색 + 가격낮은순
	@Query(value = "SELECT h.hotel_No, h.hotel_name, h.hotel_price, h.hotel_star, h.hotel_desc, h.hotel_local,h.hotel_map FROM hotel h where h.hotel_name like '%'||?1||'%' or h.hotel_local like '%'||?1||'%' GROUP BY h.hotel_no,h.hotel_name,h.hotel_local,h.hotel_desc,h.hotel_star,h.hotel_price,h.hotel_map ORDER BY h.hotel_price Asc", nativeQuery = true)
	public List<Hotel> findHotelLikeHotelNameByOrderByHotelPriceAsc(String searchKeyword);
	
	
	/****************************************************/
	
	
	
	/******************* 주소검색 + 정렬 ********************/
	
	
	// 다른 테이블과 정렬
	// 주소검색 + 예약 많은순
	@Query(value = "SELECT h.hotel_No, h.hotel_name, h.hotel_price, h.hotel_star, h.hotel_desc, h.hotel_local,h.hotel_map FROM hotel h LEFT JOIN hotel_booking hb ON h.hotel_No = hb.hotel_No where h.hotel_local like '%'||?1||'%' or h.hotel_local like '%'||?1||'%' GROUP BY h.hotel_no,h.hotel_name,h.hotel_local,h.hotel_desc,h.hotel_star,h.hotel_price,h.hotel_map ORDER BY COUNT(hb.hb_No) DESC", nativeQuery = true)
	public List<Hotel> findHotelLikeHotelLocalByBookingCountDesc(String searchKeyword);
	
	// 주소검색 + 리뷰 많은순
	@Query(value = "SELECT h.hotel_No, h.hotel_name, h.hotel_price, h.hotel_star, h.hotel_desc, h.hotel_local,h.hotel_map FROM hotel h LEFT JOIN hotel_review hr ON h.hotel_No = hr.hotel_No where h.hotel_local like '%'||?1||'%' or h.hotel_local like '%'||?1||'%' GROUP BY h.hotel_no,h.hotel_name,h.hotel_local,h.hotel_desc,h.hotel_star,h.hotel_price,h.hotel_map ORDER BY COUNT(hr.hr_No) DESC", nativeQuery = true)
	public List<Hotel> findHotelLikeHotelLocalOrderByReviewCountDesc(String searchKeyword);
	
	
	// 같은 테이블에서 정렬
	// 주소검색 + 별점 많은순
	@Query(value = "SELECT h.hotel_No, h.hotel_name, h.hotel_price, h.hotel_star, h.hotel_desc, h.hotel_local,h.hotel_map FROM hotel h where h.hotel_local like '%'||?1||'%' or h.hotel_local like '%'||?1||'%' GROUP BY h.hotel_no,h.hotel_name,h.hotel_local,h.hotel_desc,h.hotel_star,h.hotel_price,h.hotel_map ORDER BY h.hotel_star DESC", nativeQuery = true)
	public List<Hotel> findHotelLikeHotelLocalByOrderByHotelStarDesc(String searchKeyword);
	// 주소검색 + 가격높은순
	@Query(value = "SELECT h.hotel_No, h.hotel_name, h.hotel_price, h.hotel_star, h.hotel_desc, h.hotel_local,h.hotel_map FROM hotel h where h.hotel_local like '%'||?1||'%' or h.hotel_local like '%'||?1||'%' GROUP BY h.hotel_no,h.hotel_name,h.hotel_local,h.hotel_desc,h.hotel_star,h.hotel_price,h.hotel_map ORDER BY h.hotel_price DESC", nativeQuery = true)
	public List<Hotel> findHotelLikeHotelLocalByOrderByHotelPriceDesc(String searchKeyword);
	// 주소검색 + 가격낮은순
	@Query(value = "SELECT h.hotel_No, h.hotel_name, h.hotel_price, h.hotel_star, h.hotel_desc, h.hotel_local,h.hotel_map FROM hotel h where h.hotel_local like '%'||?1||'%' or h.hotel_local like '%'||?1||'%' GROUP BY h.hotel_no,h.hotel_name,h.hotel_local,h.hotel_desc,h.hotel_star,h.hotel_price,h.hotel_map ORDER BY h.hotel_price Asc", nativeQuery = true)
	public List<Hotel> findHotelLikeHotelLocalByOrderByHotelPriceAsc(String searchKeyword);
	
	
	/****************************************************/
	
	
	
	/******************* 검색 + 카테고리 ********************/
	
	
	// 이름검색 + 카테고리
	@Query(value = "select h.hotel_No, h.hotel_name, h.hotel_price, h.hotel_star, h.hotel_desc, h.hotel_local,h.hotel_map from hotel h join hotel_category_item hci on h.hotel_no = hci.hotel_no where hci.hc_no = ?1 and (h.hotel_name like '%'||?2||'%' or h.hotel_local like '%'||?2||'%') group by h.hotel_no,h.hotel_name,h.hotel_local,h.hotel_desc,h.hotel_star,h.hotel_price,h.hotel_map", nativeQuery = true)
	public List<Hotel> findByHotelCategoryItemsHotelCategoryHcNoAndHotelNameLike(Long hcNo, String searchKeyword);

	// 주소검색 + 카테고리
	@Query(value = "select h.hotel_No, h.hotel_name, h.hotel_price, h.hotel_star, h.hotel_desc, h.hotel_local,h.hotel_map from hotel h join hotel_category_item hci on h.hotel_no = hci.hotel_no where hci.hc_no = ?1 and (h.hotel_local like '%'||?2||'%' or h.hotel_local like '%'||?2||'%') group by h.hotel_no,h.hotel_name,h.hotel_local,h.hotel_desc,h.hotel_star,h.hotel_price,h.hotel_map", nativeQuery = true)
	public List<Hotel> findByHotelCategoryItemsHotelCategoryHcNoAndHotelLocalLike(Long hcNo, String searchKeyword);
	
	
	/****************************************************/
	
	
	
	
	// 카테고리 아이템 번호를 가지고 있는 모든 호텔 리스트
	//List<Hotel> findByHotelCategoryItemsHciNo(Long hciNo);
	
	// 카테고리 아이템 번호를 가지고 있는 모든 호텔 리스트 (페이징)
	//Page<Hotel> findByHotelCategoryItemsHciNo(Long hciNo, Pageable pageable);
	
}
