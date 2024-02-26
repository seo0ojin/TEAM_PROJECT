package com.jeju.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jeju.entity.HotelReview;

public interface HotelReviewRepository extends JpaRepository<HotelReview, Long>{

	// 내가 쓴 호텔리뷰 전체보기
	Page<HotelReview> findByUserinfoUserNo(Long userNo, Pageable pageable);
	List<HotelReview> findByUserinfoUserNo(Long userNo);
	
	// 호텔별 리뷰 전체보기
	Page<HotelReview> findByHotelHotelNo(Long hotelNo, Pageable pageable);
	List<HotelReview> findByHotelHotelNo(Long hotelNo);
	
	// 호텔별 높은 별점순 리뷰 정렬
	Page<HotelReview> findByHotelHotelNoOrderByHrStarDesc(Long hotelNo, Pageable pageable);
	List<HotelReview> findByHotelHotelNoOrderByHrStarDesc(Long hotelNo);
	
	// 호텔별 낮은 별점순 리뷰 정렬
	Page<HotelReview> findByHotelHotelNoOrderByHrStarAsc(Long hotelNo, Pageable pageable);
	List<HotelReview> findByHotelHotelNoOrderByHrStarAsc(Long hotelNo);
	
	// 호텔별 최신 리뷰 정렬
	Page<HotelReview> findByHotelHotelNoOrderByHrDateDesc(Long hotelNo, Pageable pageable);
	List<HotelReview> findByHotelHotelNoOrderByHrDateDesc(Long hotelNo);
	
	// 호텔별 오래된 리뷰 정렬
	Page<HotelReview> findByHotelHotelNoOrderByHrDateAsc(Long hotelNo, Pageable pageable);
	List<HotelReview> findByHotelHotelNoOrderByHrDateAsc(Long hotelNo);
	
	// 호텔별 리뷰 번호로 정렬
	List<HotelReview> findByHotelHotelNoOrderByHrNoDesc(Long hotelNo);
	
	// 유저, 호텔 번호로 리뷰 찾기
	List<HotelReview> findByUserinfoUserNoAndHotelHotelNo(Long userNo, Long hotelNo);
	
    // 호텔별 평균 별점 계산
    //@Query("SELECT AVG(hr.hrStar) FROM HotelReview hr WHERE hr.hotel.hotelNo = :hotelNo")
	//Double calculateAverageStarRating(@Param("hotelNo") Long hotelNo); 
	//Double findAverageHrStarByHotel_HotelNo(Long hotelNo);
}
