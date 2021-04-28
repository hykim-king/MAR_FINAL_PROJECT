package com.sist.mar.cart.controller;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.sist.mar.cart.domain.Cart;
import com.sist.mar.cart.service.CartService;
import com.sist.mar.cmn.Search;

@Controller
public class cartController {

	final Logger LOG = LoggerFactory.getLogger(cartController.class);
	
	@Autowired
	CartService cartService;
	
	// 장바구니 페이지 -------------------------------------------------------------------------------------
	@RequestMapping(value = "cart/cart_list.do")
	public String cart_list() throws SQLException {
		LOG.debug("===============");
		LOG.debug("= cart_list() =");
		LOG.debug("===============");
		
		//처음 조회 속도 향상을 위해 전체 검색 1회 실행
		doRetrieve("");
		
		return "cart/cart_list";
	}
	
	// 장바구니 삭제 -------------------------------------------------------------------------------------
	@RequestMapping(value = "cart/do_delete.do", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String doDelete(String param) throws SQLException {
		LOG.debug("= doDelete() =");
		LOG.debug("param : " + param);
		
		int flag = cartService.doDelete(param);
		String message = "";
		if(flag == 1) {
			message = "성공";
		} else {
			message = "실패";
		}
		Gson gson = new Gson();
		String jsonStr = gson.toJson(message);
		LOG.debug("jsonStr : " + jsonStr);
		return jsonStr;
	}
	
	// 장바구니 등록 -------------------------------------------------------------------------------------
	@RequestMapping(value = "cart/do_insert.do", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String doInsert(Cart cart) throws SQLException {
		LOG.debug("= doInsert() =");
		LOG.debug("cart : " + cart);
		
		int checkFlag = cartService.cartCheck(cart);
		String msg = "";
		if (checkFlag == 0) {
			//동일상품이 장바구니에 없다면 등록
			int flag = cartService.doInsert(cart);
			if(1 == flag) {
				msg = "장바구니에 상품을 담았습니다.";
			} else {
				msg = "상품을 담지 못했습니다.";
			}
		} else {
			//동일상품이 장바구니에 있다면 등록x
			msg = "장바구니에 존재하는 상품입니다.";
		}

		Gson gson = new Gson();
		String jsonStr = gson.toJson(msg);
		LOG.debug("jsonStr : " + jsonStr);
		return jsonStr;
	}
	
	// 장바구니 수량 수정 -------------------------------------------------------------------------------------
	@RequestMapping(value = "cart/do_update.do", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String doUpdate(Cart cart) throws SQLException {
		LOG.debug("= doUpdate() =");
		LOG.debug("cart : " + cart);

		int flag = cartService.doUpdate(cart);
		String msg = "";
		if (1 == flag) {
			msg = "수량이 적용되었습니다.";
		} else {
			msg = "수량 변경을 실패했습니다.";
		}

		Gson gson = new Gson();
		String jsonStr = gson.toJson(msg);
		LOG.debug("jsonStr : " + jsonStr);
		return jsonStr;
	}
	
	// 장바구니 조회 -------------------------------------------------------------------------------------
	@RequestMapping(value = "cart/do_retrieve.do", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String doRetrieve(String param) throws SQLException{
		LOG.debug("= doRetrieve() =");
		LOG.debug("param : " + param);
	
		List<Cart> list = (List<Cart>) cartService.doRetrieve(param);
		for(Cart vo : list) {
			LOG.debug(vo.toString());
		}

		//List to Json
		Gson gson = new Gson();
		String jsonList = gson.toJson(list);
		LOG.debug("jsonList : " + jsonList);
		return jsonList;
	}
	
}
