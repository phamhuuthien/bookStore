package database;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import model.Author;
import model.Books;
import model.Category;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;

public class insertDataBook {
    public static void main(String[] args) {
        // Đường dẫn đến tệp JSON cần đọc
        String filePath = "C:\\Users\\ASUS\\OneDrive\\bi\\Desktop\\java\\workspace\\ecommerce_bookStore\\src\\main\\java\\database\\data.json";
        try {
            // Đọc file JSON
            FileReader reader = new FileReader(filePath);

            // Sử dụng Gson để parse JSON
            Gson gson = new Gson();
            JsonObject data = gson.fromJson(reader, JsonObject.class);

            ArrayList<Books> list = new ArrayList<>();
            categoryDAO categoryD = new categoryDAO();

            for (String key : data.keySet()) {
                JsonArray items = data.getAsJsonArray(key);
                for (JsonElement item : items) {
                    Books books = new Books();
                    String idBook = UUID.randomUUID().toString();
                    books.setIdBook(idBook);
                    
                    // Set category
                    Category category = new Category(null, key);
                    Category categoryNew = categoryD.selectByTitleCategory(category);
                    books.setCategory(categoryNew);
                    
                    // Set author
                    Author author = new Author("1", null, null, null);
                    books.setAuthor(author);
                    
                    // Set public year
                    String publicYear = "2023";
                    books.setPublicYear(publicYear);
                    
                    // Set description
                    books.setDescription("What words come to mind when we think of God? Merciful? Just? Compassionate? In fact, the Bible lays out God’s primary qualities clearly: jealous, petty, unforgiving, bloodthirsty, vindictive—and worse! Originally conceived as a joint presentation between influential thinker and bestselling author Richard Dawkins and former evangelical preacher Dan Barker, this unique book What words come to mind when we think of God? Merciful? Just? Compassionate? In fact, the Bible lays out God’s primary qualities clearly: jealous, petty, unforgiving, bloodthirsty, vindictive—and worse! Originally conceived as a joint presentation between influential thinker and bestselling author Richard Dawkins and former evangelical preacher Dan Barker, this unique book provides an investigation into what may be the most unpleasant character in all fiction. Barker combs through both the Old and New Testament (as well as thirteen different editions of the “Good Book”), presenting powerful evidence for why the Scripture shouldn’t govern our everyday lives. This witty, well-researched book suggests that we should move past the Bible and clear a path to a kinder and more thoughtful world. ...more");
                    
                    JsonObject book = item.getAsJsonObject();
                    String bookTitle = book.get("bookTitle").getAsString();
                    books.setTitle(bookTitle);
                    
                    Double price = book.get("bookPrice").getAsDouble();
                    books.setPrice(price);
                    
                    int available = book.get("available").getAsInt();
                    books.setAvailable(available);
                    
                    String fileName = book.get("imagesUrl").getAsString();
                    books.setFileName(fileName);
                    
                    String star = book.get("star").getAsString();
                    double starDou = 0;
                    if (star.equals("One")) {
                        starDou = 1;
                    } else if (star.equals("Two")) {
                        starDou = 2;
                    } else if (star.equals("Three")) {
                        starDou = 3;
                    } else if (star.equals("Four")) {
                        starDou = 4;
                    } else if (star.equals("Five")) {
                        starDou = 5;
                    }
                    books.setStar(starDou);
                    
                    list.add(books);
                }
            }

            // In danh sách ra để kiểm tra
//            for (Books book : list) {
//                System.out.println(book.getTitle());
//            }
            BookDAO bookD = new BookDAO();
            System.out.println(bookD.insertAll(list));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


