package beans;

import java.util.List;
import java.util.Map;

import util.DButils;

public class Book {
	private String id;
	private String bookname;
	private String author;
	private String press;
	private String price;
	private DButils db;
	//初始化数据库连接类
	public Book(){
		db=new DButils();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPress() {
		return press;
	}
	public void setPress(String press) {
		this.press = press;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public DButils getDb() {
		return db;
	}
	public void setDb(DButils db) {
		this.db = db;
	}
	//读取所有的图书的信息
	public List getAllBooks(){
		List books=null;
		String sql="select * from bookinfo";
		String[] params={null};
		books=db.getList(sql, params);
		return books;
	}
	//添加图书
	public int addBook(){
		int result=0;
		String sql="insert into bookinfo(bookname,author,press,price)values(?,?,?,?)";
		String[] params={bookname,author,press,price};
		result=db.update(sql, params);
		return result;
	}
	//通过图书id获取图书信息
	public Map getBook(){
		Map book=null;
		String sql="select * bookinfo where id=?";
		String[] params={id};
		book=db.getMap(sql, params);
		return book;
	}
	//修改图书信息；
	public int update(){
		int result=0;
		String sql="update bookinfo set bookname=?,author=?,press=?,price=? where id=?";
		String[] params={bookname,author,press,price,id};
		result=db.update(sql, params);
		return result;
	}
	//删除图书信息
	public int delete(){
		int result=0;
			String sql="delete from bookinfo where id=?";
			String[] params={id};
			result=db.update(sql, params);
			return result;
		}
	

}
