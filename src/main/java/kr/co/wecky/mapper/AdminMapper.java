package kr.co.wecky.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kr.co.wecky.dto.AdminDto;

@Mapper
public interface AdminMapper {

	int adminInsert(@Param("adminDto") AdminDto adminDto);

	AdminDto loginConfirm(@Param("adminDto") AdminDto adminDto);

	List<AdminDto> adminList();

}
