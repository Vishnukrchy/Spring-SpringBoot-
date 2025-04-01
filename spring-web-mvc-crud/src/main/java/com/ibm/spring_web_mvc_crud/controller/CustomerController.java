package com.ibm.spring_web_mvc_crud.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.tags.shaded.org.apache.xpath.functions.FuncFalse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ibm.spring_web_mvc_crud.dao.CustomerDao;
import com.ibm.spring_web_mvc_crud.dto.User;

import jakarta.servlet.annotation.MultipartConfig;

@Controller
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class CustomerController {

	@Autowired
	private CustomerDao customerDao;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String openIndex() {
		return "index";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView openRegister() {

		// ModelAndView andView = new ModelAndView("register");

		// return andView.addObject("user", new User());

		return new ModelAndView("register").addObject("user", new User());
	}

	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public ModelAndView registerUser(User user) throws IOException {

		customerDao.saveUserDao(user);

		return new ModelAndView("/register");
	}

	private static Path convert(MultipartFile file) throws IOException {
		Path newFile = Paths.get(file.getOriginalFilename());
		try (InputStream is = file.getInputStream(); OutputStream os = Files.newOutputStream(newFile)) {
			byte[] buffer = new byte[4096];
			int read = 0;
			while ((read = is.read(buffer)) > 0) {
				os.write(buffer, 0, read);
			}
		}
		return newFile;
	}

	List<User> users = null;

	@GetMapping(value = "/display")
	public ModelAndView registerUserController() {

		users = customerDao.getAllUserDetailsDao();

		ModelAndView andView = new ModelAndView("display");

		return andView.addObject("user", users);
	}

	@GetMapping(value = "/delete")
	public ModelAndView deleteUserByIdController(@RequestParam("id") int id) {

		customerDao.deleteUserByIdDao(id);

		users = customerDao.getAllUserDetailsDao();

		return new ModelAndView("display").addObject("user", users);
	}

	@GetMapping(value = "/update")
	public ModelAndView openUpdateController(@RequestParam("id") int id) {

		User user = customerDao.fetchUserByIdDao(id);

		return new ModelAndView("update").addObject(user);
	}

	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public ModelAndView updateUserController(User user) throws IOException {

		System.out.println(user);
		User user1 = customerDao.fetchUserByIdDao(user.getId());

		if (user1 != null) {
			user1.setName(user.getName());
			user1.setEmail(user.getEmail());
			user1.setImage(user.getImage());

			customerDao.updateUserDao(user1);
		}
		return new ModelAndView("display").addObject("user", customerDao.getAllUserDetailsDao());
	}

}
