package com.geppetto.sociallogin.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.geppetto.sociallogin.domain.core.GpUser;
import com.geppetto.sociallogin.service.GpUserService;
/**
 * 
 * @author Rashmi
 *
 */


@Controller("GpUserController")
@RequestMapping("/login/")
public class GpUserController {

		private GpUserService user_service;

		public GpUserService getUser_service() {
			return user_service;
		}

		@Resource(name = "GpUserService")
		public void setUser_service(GpUserService user_service) {
			this.user_service = user_service;
		}


		/**
		 * This method creates a new user if it does not exist 
		 * @param user
		 * @return
		 * @throws Exception
		 */
		@RequestMapping(method = RequestMethod.POST, value = "/create_user/", headers = "Accept=application/json")
		@ResponseBody
		public GpUser create_user(@RequestBody GpUser user) throws Exception {
			System.out.println("create user method calling!");

			GpUser gpuser = user_service.find_user(user.getUsername());
			if (gpuser == null) {
				// create a new user in DB
				GpUser newgpUser = new GpUser();
				newgpUser.setUsername(user.getUsername());
				newgpUser.setPassword("geppetto");
				gpuser = newgpUser;

				gpuser = this.user_service.create_user(user);
				
			} else{
				System.out.println("user already exists!");
				gpuser = user;
				
			}
			
			return gpuser;
		}


	}


