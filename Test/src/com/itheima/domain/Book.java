package com.itheima.domain;

import java.io.Serializable;

//javabean最好实现序列化serializable接口,
public class Book implements Serializable{
		private String author;
		private String id;
		private String name;
		private String price;
		private String publish;
		private String discrible;
		
		public Book() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		public Book( String id, String name, String author,String price, String publish, String discrible) {
			super();
			this.author = author;
			this.id = id;
			this.name = name;
			this.price = price;
			this.publish = publish;
			this.discrible = discrible;
		}

		public String getAuthor() {
			return author;
		}
		public void setAuthor(String author) {
			this.author = author;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPrice() {
			return price;
		}
		public void setPrice(String price) {
			this.price = price;
		}
		public String getPublish() {
			return publish;
		}
		public void setPublish(String publish) {
			this.publish = publish;
		}

		public String getDiscrible() {
			return discrible;
		}

		public void setDiscrible(String discrible) {
			this.discrible = discrible;
		}
		
}
