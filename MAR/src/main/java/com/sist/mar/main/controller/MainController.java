package com.sist.mar.main.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.sist.mar.cmn.StringUtil;
import com.sist.mar.code.domain.Code;
import com.sist.mar.code.service.CodeService;
import com.sist.mar.main.domain.CateSearchVO;
import com.sist.mar.main.domain.MainVO;
import com.sist.mar.main.service.MainService;

@Controller
public class MainController {
	
	final Logger LOG = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	MainService mainService;
	@Autowired
	CodeService codeService;
	
	public MainController() {}
	
	//<<<<<main화면 연결>>>>>
	@RequestMapping(value= "main/main_view.do")
	public String main(Model model) throws SQLException {
		LOG.debug("******************************************************");
		LOG.debug("* 메인 화면 load *");
		LOG.debug("******************************************************");
	
		List codeListParam = new ArrayList<String>();
		codeListParam.add("LIST_DIV");//목록구분
		
		List<Code> codeList = getCodePageRetrieve(codeListParam);
		
		List<Code> comListDiv = new ArrayList<Code>();
		
		for(Code vo:codeList) {
			if(vo.getMstCode().equals("LIST_DIV")) {
				comListDiv.add(vo);
				LOG.debug(vo.toString());
			}
		}
		model.addAttribute("LIST_DIV", comListDiv);
		
		return "main/main";
	}
	

	
	//<<<<목록조회 메서드>>>>
	@RequestMapping(value="main/do_retrieve.do", method=RequestMethod.GET
			,produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String doRetrieve(CateSearchVO search) throws SQLException {
		LOG.debug(" ٩( ᐛ )و Controller의 doRetrieve()시작! ");
		LOG.debug("================================");
		LOG.debug("search param: "+search);
		LOG.debug("================================");
		
		//NVL처리
		//검색어가 없을 시 ""처리
		search.setSearchWord(StringUtil.nvl(search.getSearchWord(), ""));
		//목록분류 없을 시 20(신상품조회)처리
		search.setListDiv(StringUtil.nvl(search.getListDiv(),"20"));
		//페이지NUM에 0이 들어올 시 
		if(search.getPageNum()==0) {
			search.setPageNum(1);//1로 만들어줌
		}
		//페이지사이즈에 0이 들어올 시
		if(search.getPageSize()==0) {
			search.setPageSize(10);//10으로 만들어줌
		}
		
		LOG.debug("================================");
		LOG.debug("param_init(초기화): "+search);
		LOG.debug("================================");
		
		List<MainVO> list = (List<MainVO>) this.mainService.doRetrieve(search);
		
		for(MainVO vo:list) {
			LOG.debug(vo.toString());
		}
		
		Gson gson = new Gson();
		String jsonList = gson.toJson(list);//object -> json 
		LOG.debug("================================");
		LOG.debug("jsonList: "+jsonList);
		LOG.debug("================================");
		
		return jsonList;
	}
	
	private List<?> getCodePageRetrieve(List<String> codeList) throws SQLException {
	Map<String,Object> codeMap = new HashMap<String,Object>();
	
	codeMap.put("codeList",codeList);
	
	return codeService.getCodeRetrieve(codeMap);
	}

}