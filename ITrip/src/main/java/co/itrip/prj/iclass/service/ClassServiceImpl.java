package co.itrip.prj.iclass.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.itrip.prj.iclass.mapper.ClassMapper;

@Service
public class ClassServiceImpl implements ClassService {
	
	@Autowired
	private ClassMapper map;

	@Override
	public List<ClassVO> classSelectList(ClassVO vo) {
		// TODO Auto-generated method stub
		return map.classSelectList(vo);
	}

	@Override
	public ClassVO classSelect(ClassVO vo) {
		// TODO Auto-generated method stub
		return map.classSelect(vo);
	}

	@Override
	public int classInsert(ClassVO vo) {
		
		int r = map.classInsert(vo);
		
		ClassDtVO dtvo = new ClassDtVO();
		dtvo.setClassNo(vo.getClassNo());
		
		for(int i=0; i < vo.getClassDt().size(); i++) {
			if(vo.getClassDt().get(i) != null) {
				dtvo.setTerm(vo.getClassDt().get(i).getTerm());
				dtvo.setTerm(vo.getClassDt().get(i).getTerm());
				dtvo.setCtimeNo(++i);
				dtvo.setBeginTime(vo.getClassDt().get(i).getBeginTime());
				dtvo.setEndTime(vo.getClassDt().get(i).getEndTime());
				map.classDtInsert(dtvo);
			}
			
		}
		
		return r;
	}

	@Override
	public int classDelete(ClassVO vo) {
		// TODO Auto-generated method stub
		return map.classDelete(vo);
	}

}
