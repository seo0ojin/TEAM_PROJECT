package com.jeju.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jeju.entity.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long>{
	
	//public Page<Restaurant> findByRestaurantCategory(String restaurantCategory, Pageable pageable);
	
	public List<Restaurant> findByRestaurantNameLike(String restaurantName);
	
	public Page<Restaurant> findByRestaurantNameLike(String restaurantName, Pageable pageable);
	
	public List<Restaurant> findByRestaurantAddressLike(String restaurantAddress);
	
	public Page<Restaurant> findByRestaurantAddressLike(String restaurantAddress, Pageable pageable);
	
	// 리뷰 많은순
	@Query(value = "SELECT r.restaurant_No, r.restaurant_name, r.restaurant_address, r.restaurant_star, r.restaurant_tel, r.restaurant_desc, r.restaurant_map FROM Restaurant r LEFT JOIN Restaurant_Review rr ON r.restaurant_No = rr.restaurant_No GROUP BY r.restaurant_No, r.restaurant_name, r.restaurant_address, r.restaurant_star, r.restaurant_tel, r.restaurant_desc, r.restaurant_map ORDER BY COUNT(rr.rr_No) DESC", nativeQuery = true)
	public List<Restaurant> findRestaurantOrderByReviewCountDesc();
	
	// 별점 높은순
	@Query(value = "SELECT r.restaurant_No, r.restaurant_name, r.restaurant_address, r.restaurant_star, r.restaurant_tel, r.restaurant_desc, r.restaurant_map FROM Restaurant r LEFT JOIN Restaurant_Review rr ON r.restaurant_No = rr.restaurant_No GROUP BY r.restaurant_No, r.restaurant_name, r.restaurant_address, r.restaurant_star, r.restaurant_tel, r.restaurant_desc, r.restaurant_map ORDER BY r.restaurant_star DESC", nativeQuery = true)
	public List<Restaurant> findAllByOrderByRestaurantStarDesc();
	
	// 예약 많은순
	@Query(value = "SELECT r.restaurant_No, r.restaurant_name, r.restaurant_address, r.restaurant_star, r.restaurant_tel, r.restaurant_desc, r.restaurant_map FROM Restaurant r LEFT JOIN Restaurant_Booking rb ON r.restaurant_No = rb.restaurant_No GROUP BY r.restaurant_No, r.restaurant_name, r.restaurant_address, r.restaurant_star, r.restaurant_tel, r.restaurant_desc,r.restaurant_map ORDER BY COUNT(rb.rb_No) DESC", nativeQuery = true)
	public List<Restaurant> findAllByBookingCountDesc();
	
	// 카테고리 이름으로 레스토랑 뽑기
	public List<Restaurant> findByRestaurantCategoryItemsRestaurantCategoryRcName(String rcName);
	
	// 카테고리 번호로 레스토랑 뽑기
	public List<Restaurant> findByRestaurantCategoryItemsRestaurantCategoryRcNo(Long rcNo);
	
	// 예약많은순 + 카테고리
	@Query(value = "SELECT r.restaurant_No, r.restaurant_name, r.restaurant_address, r.restaurant_star, r.restaurant_tel, r.restaurant_desc, r.restaurant_map\r\n"
			+ "FROM restaurant r\r\n"
			+ "JOIN restaurant_category_item rci ON r.restaurant_no = rci.restaurant_no\r\n"
			+ "LEFT JOIN restaurant_booking rb ON r.restaurant_no = rb.restaurant_no\r\n"
			+ "WHERE rci.rc_no = :categoryNo\r\n"
			+ "GROUP BY r.restaurant_no, r.restaurant_name, r.restaurant_address, r.restaurant_star,\r\n"
			+ "         r.restaurant_tel, r.restaurant_desc, r.restaurant_map\r\n"
			+ "ORDER BY COUNT(rb.rb_no) DESC",nativeQuery = true)
	public List<Restaurant> findByCategoryNoOrderByBookingsDesc(@Param("categoryNo") Long categoryNo);
	
	// 별점많은순 + 카테고리
	@Query(value="select r.restaurant_No, r.restaurant_name, r.restaurant_address, r.restaurant_star, r.restaurant_tel, r.restaurant_desc, r.restaurant_map from restaurant r\r\n"
			+ "join restaurant_category_item rci on r.restaurant_no = rci.restaurant_no\r\n"
			+ "where rci.rc_no = ?1\r\n"
			+ "group by r.restaurant_no,r.restaurant_name,r.restaurant_address,r.restaurant_desc,r.restaurant_star,r.restaurant_tel, r.restaurant_map\r\n"
			+ "ORDER BY r.restaurant_star DESC",nativeQuery = true)
	public List<Restaurant> findByCategoryNoOrderByStars(@Param("categoryNo") Long categoryNo);
	
	// 리뷰많은순 + 카테고리
	@Query(value="select r.restaurant_No, r.restaurant_name, r.restaurant_address, r.restaurant_star, r.restaurant_tel, r.restaurant_desc, r.restaurant_map from restaurant r\r\n"
			+ "LEFT join restaurant_review rr on r.restaurant_no = rr.restaurant_no\r\n"
			+ "join restaurant_category_item rci on r.restaurant_no = rci.restaurant_no\r\n"
			+ "where rci.rc_no = ?1\r\n"
			+ "group by r.restaurant_no,r.restaurant_name,r.restaurant_address,r.restaurant_desc,r.restaurant_star,r.restaurant_tel, r.restaurant_map\r\n"
			+ "ORDER BY COUNT(rr.rr_no) DESC",nativeQuery = true)
	public List<Restaurant> findByCategoryNoOrderByReviewsDesc(@Param("categoryNo") Long categoryNo);
	
	// 검색 + 카테고리 + 예약 많은순
	@Query(value = "SELECT r.restaurant_No, r.restaurant_name, r.restaurant_address, r.restaurant_star, r.restaurant_tel, r.restaurant_desc, r.restaurant_map FROM restaurant r LEFT JOIN restaurant_booking rb ON r.restaurant_no = rb.restaurant_no JOIN restaurant_category_item rci ON r.restaurant_no = rci.restaurant_no WHERE rci.rc_no = ?1 and (r.restaurant_name like '%'||?2||'%' or r.restaurant_address like '%'||?2||'%') GROUP BY r.restaurant_no, r.restaurant_name, r.restaurant_address, r.restaurant_star,r.restaurant_tel, r.restaurant_desc, r.restaurant_map ORDER BY COUNT(rb.rb_no) DESC", nativeQuery = true)
	public List<Restaurant> findRestaurantLikeRestaurantNameByCategoryNoOrderByBookingsDesc(Long categoryNo , String searchKeyword );
	
	// 검색 + 카테고리 + 별점순
	@Query(value = "select r.restaurant_No, r.restaurant_name, r.restaurant_address, r.restaurant_star, r.restaurant_tel, r.restaurant_desc, r.restaurant_map from restaurant r join restaurant_category_item rci on r.restaurant_no = rci.restaurant_no where rci.rc_no = ?1 and (r.restaurant_name like '%'||?2||'%' or r.restaurant_address like '%'||?2||'%') group by r.restaurant_no,r.restaurant_name,r.restaurant_address,r.restaurant_desc,r.restaurant_star,r.restaurant_tel, r.restaurant_map  ORDER BY r.restaurant_star DESC",nativeQuery = true)
	public List<Restaurant> findRestaurantLikeRestaurantNameByCategoryNoOrderByStars(Long categoryNo, String searchKeyword);
	
	// 검색 + 카테고리 + 리뷰 많은순
	@Query(value = "select r.restaurant_No, r.restaurant_name, r.restaurant_address, r.restaurant_star, r.restaurant_tel, r.restaurant_desc, r.restaurant_map from restaurant r LEFT join restaurant_review rr on r.restaurant_no = rr.restaurant_no join restaurant_category_item rci on r.restaurant_no = rci.restaurant_no where rci.rc_no = ?1 and (r.restaurant_name like '%'||?2||'%' or r.restaurant_address like '%'||?2||'%') group by r.restaurant_no,r.restaurant_name,r.restaurant_address,r.restaurant_desc,r.restaurant_star,r.restaurant_tel, r.restaurant_map ORDER BY COUNT(rr.rr_no) DESC",nativeQuery = true)
	public List<Restaurant> findRestaurantLikeRestaurantNameByCategoryNoOrderByReviewsDesc(Long categoryNo , String searchKeyword );
	
	// 검색 + 예약 많은순
	@Query(value = "SELECT r.restaurant_No, r.restaurant_name, r.restaurant_address, r.restaurant_star, r.restaurant_tel, r.restaurant_desc, r.restaurant_map FROM Restaurant r LEFT JOIN Restaurant_Booking rb ON r.restaurant_No = rb.restaurant_No where r.restaurant_name like '%'||?1||'%' or r.restaurant_address like '%'||?1||'%' GROUP BY r.restaurant_No, r.restaurant_name, r.restaurant_address, r.restaurant_star, r.restaurant_tel, r.restaurant_desc, r.restaurant_map ORDER BY COUNT(rb.rb_No) DESC", nativeQuery = true)
	public List<Restaurant> findRestaurantLikeRestaurantNameByBookingCountDesc(String searchKeyword);
	
	// 검색 + 별점 많은순
	@Query(value = "SELECT r.restaurant_No, r.restaurant_name, r.restaurant_address, r.restaurant_star, r.restaurant_tel, r.restaurant_desc, r.restaurant_map FROM Restaurant r where r.restaurant_name like '%'||?1||'%' or r.restaurant_address like '%'||?1||'%' GROUP BY r.restaurant_No, r.restaurant_name, r.restaurant_address, r.restaurant_star, r.restaurant_tel, r.restaurant_desc, r.restaurant_map ORDER BY r.restaurant_star DESC", nativeQuery = true)
	public List<Restaurant> findRestaurantLikeRestaurantNameByOrderByRestaurantStarDesc(String searchKeyword);
	
	// 검색 + 리뷰 많은순
	@Query(value = "SELECT r.restaurant_No, r.restaurant_name, r.restaurant_address, r.restaurant_star, r.restaurant_tel, r.restaurant_desc, r.restaurant_map FROM Restaurant r LEFT JOIN Restaurant_Review rr ON r.restaurant_No = rr.restaurant_No where r.restaurant_name like '%'||?1||'%' or r.restaurant_address like '%'||?1||'%' GROUP BY r.restaurant_No, r.restaurant_name, r.restaurant_address, r.restaurant_star, r.restaurant_tel, r.restaurant_desc, r.restaurant_map ORDER BY COUNT(rr.rr_No) DESC", nativeQuery = true)
	public List<Restaurant> findRestaurantLikeRestaurantNameOrderByReviewCountDesc(String searchKeyword);
	
	// 검색 + 카테고리
	@Query(value = "select r.restaurant_No, r.restaurant_name, r.restaurant_address, r.restaurant_star, r.restaurant_tel, r.restaurant_desc, r.restaurant_map from restaurant r join restaurant_category_item rci on r.restaurant_no = rci.restaurant_no where rci.rc_no = ?1 and (r.restaurant_name like '%'||?2||'%' or r.restaurant_address like '%'||?2||'%') group by r.restaurant_no,r.restaurant_name,r.restaurant_address,r.restaurant_desc,r.restaurant_star,r.restaurant_tel, r.restaurant_map",nativeQuery = true)
	public List<Restaurant> findByRestaurantCategoryItemsRestaurantCategoryRcNoAndRestaurantNameLike(Long rcNo,String searchKeyword);
	
	// 메뉴로 식당찾기
    //List<Restaurant> findByRestaurantMenusRmNameLike(String rmName);
   
}
