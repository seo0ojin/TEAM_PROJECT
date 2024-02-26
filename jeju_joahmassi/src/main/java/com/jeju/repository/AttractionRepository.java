package com.jeju.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jeju.entity.Attraction;

public interface AttractionRepository extends JpaRepository<Attraction, Long>{

	// 명소 이름 검색
	public List<Attraction> findByAttractionNameLike(String attractionName);
	
	// 명소 주소 검색
	public List<Attraction> findByAttractionAddressLike(String attractionAddress);
	
	/*
	// 명소 이름 검색
	public Page<Attraction> findByAttractionNameLike(String attractionName, Pageable pagable);
	
	// 명소 주소 검색
	public Page<Attraction> findByAttractionAddressLike(String attractionAddress, Pageable pageable);
	*/
	
	// 리뷰 많은 순
	@Query(value = "select a.attraction_no, a.attraction_name, a.attraction_address, a.attraction_star, a.attraction_desc,a.attraction_map from attraction a left join attraction_review ar on a.attraction_no = ar.attraction_no group by a.attraction_no, a.attraction_name, a.attraction_address, a.attraction_star, a.attraction_desc,a.attraction_map order by count(ar.ar_no) desc", nativeQuery = true)
	public List<Attraction> findAttractionOrderByReviewCountDesc();
	
	// 별점 높은 순
	public List<Attraction> findAllByOrderByAttractionStarDesc();
	
	// 별점 정렬
	public List<Attraction> findByAttractionStar(int attractionStar);
	
	// 카테고리 번호로 명소 뽑기
	public List<Attraction> findByAttractionCategoryItemsAttractionCategoryAcNo(Long acNo);
	
	// 한 개의 카테고리에 몇 개의 명소가 있는지 카운트
	@Query(value = "select count(*) from attraction_category_item where ac_no = ?1", nativeQuery = true)
	public Integer countByAttractionCategoryItemAcNo(Long acNo);
	
	/********** 이중정렬 **********/
	
	// 별점 높은 순 + 카테고리
	@Query(value = "select a.attraction_no, a.attraction_name, a.attraction_address, a.attraction_star, a.attraction_desc,a.attraction_map from attraction a join attraction_category_item aci on a.attraction_no = aci.attraction_no where aci.ac_no = ?1 group by a.attraction_no, a.attraction_name, a.attraction_address, a.attraction_desc, a.attraction_star,a.attraction_map order by a.attraction_star desc", nativeQuery = true)
	public List<Attraction> findByCategoryNoOrderByStars(@Param("categoryNo") Long categoryNo);
	
	// 리뷰 많은 순 + 카테고리
	@Query(value = "select a.attraction_no, a.attraction_name, a.attraction_address, a.attraction_star, a.attraction_desc,a.attraction_map from attraction a left join attraction_review ar on a.attraction_no = ar.attraction_no join attraction_category_item aci on a.attraction_no = aci.attraction_no where aci.ac_no = ?1 group by a.attraction_no, a.attraction_name, a.attraction_address, a.attraction_desc, a.attraction_star,a.attraction_map order by count(ar.ar_no) desc", nativeQuery = true)
	public List<Attraction> findByCategoryNoOrderByReviewsDesc(@Param("categoryNo") Long categoryNo);
	
	// 검색 + 카테고리 + 별점순
	@Query(value = "select a.attraction_no, a.attraction_name, a.attraction_address, a.attraction_star, a.attraction_desc,a.attraction_map from attraction a join attraction_category_item aci on a.attraction_no = aci.attraction_no where aci.ac_no = ?1 and (a.attraction_name like '%'||?2||'%' or a.attraction_address like '%'||?2||'%') group by a.attraction_no, a.attraction_name, a.attraction_address, a.attraction_desc, a.attraction_star,a.attraction_map order by a.attraction_star desc", nativeQuery = true)
	public List<Attraction> findAttractionLikeAttractionNameByCategoryNoOrderByStars(Long categoryNo, String searchKeyword);
	
	// 검색 + 카테고리 + 리뷰 많은순
	@Query(value = "select a.attraction_no, a.attraction_name, a.attraction_address, a.attraction_star, a.attraction_desc,a.attraction_map from attraction a left join attraction_review ar on a.attraction_no = ar.attraction_no join attraction_category_item aci on a.attraction_no = aci.attraction_no where aci.ac_no = ?1 and (a.attraction_name like '%'||?2||'%' or a.attraction_address like '%'||?2||'%') group by a.attraction_no, a.attraction_name, a.attraction_address, a.attraction_desc, a.attraction_star,a.attraction_map order by count(ar.ar_no) desc", nativeQuery = true)
	public List<Attraction> findAttractionLikeAttractionNameByCategoryNoOrderByReviewsDesc(Long categoryNo , String searchKeyword );
	
	// 검색 + 별점순
	@Query(value = "select a.attraction_no, a.attraction_name, a.attraction_address, a.attraction_star, a.attraction_desc,a.attraction_map from attraction a where a.attraction_name like '%'||?1||'%' or a.attraction_address like '%'||?1||'%' group by a.attraction_no, a.attraction_name, a.attraction_address, a.attraction_star, a.attraction_desc, a.attraction_map order by a.attraction_star desc", nativeQuery = true)
	public List<Attraction> findAttractionLikeAttractionNameByOrderByAttractionStarDesc(String searchKeyword);
	
	// 검색 + 리뷰 많은순
	@Query(value = "select a.attraction_no, a.attraction_name, a.attraction_address, a.attraction_star, a.attraction_desc,a.attraction_map from attraction a left join attraction_review ar on a.attraction_no = ar.attraction_no where a.attraction_name like '%'||?1||'%' or a.attraction_address like '%'||?1||'%' group by a.attraction_no, a.attraction_name, a.attraction_address, a.attraction_star, a.attraction_desc,a.attraction_map order by count(ar.ar_no) desc", nativeQuery = true)
	public List<Attraction> findAttractionLikeAttractionNameOrderByReviewCountDesc(String searchKeyword);
	
	// 검색 + 카테고리
	@Query(value = "select a.attraction_no, a.attraction_name, a.attraction_address, a.attraction_star, a.attraction_desc,a.attraction_map from attraction a join attraction_category_item aci on a.attraction_no = aci.attraction_no where aci.ac_no = ?1 and (a.attraction_name like '%'||?2||'%' or a.attraction_address like '%'||?2||'%') group by a.attraction_no, a.attraction_name, a.attraction_address, a.attraction_desc, a.attraction_star,a.attraction_map", nativeQuery = true)
	public List<Attraction> findByAttractionCategoryItemsAttractionCategoryAcNoAndAttractionNameLike(Long acNo, String searchKeyword);
}
