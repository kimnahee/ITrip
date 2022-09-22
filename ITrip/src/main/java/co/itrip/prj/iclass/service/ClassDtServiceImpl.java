package co.itrip.prj.iclass.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.itrip.prj.iclass.mapper.ClassDtMapper;

@Service
public class ClassDtServiceImpl implements ClassDtService {
	
	@Autowired
	private ClassDtMapper map;

	@Override
	public List<ClassDtVO> classDtSelectList(ClassDtVO vo) {
		// TODO Auto-generated method stub
		return map.classDtSelectList(vo);
	}

	@Override
	public ClassDtVO classDtSelect(ClassDtVO vo) {
		// TODO Auto-generated method stub
		return map.classDtSelect(vo);
	}

	@Override
	public int classDtInsert(ClassDtVO vo) {
		// TODO Auto-generated method stub
		return map.classDtInsert(vo);
	}

	@Override
	public int classDtDelete(ClassDtVO vo) {
		// TODO Auto-generated method stub
		return map.classDtDelete(vo);
	}

}
