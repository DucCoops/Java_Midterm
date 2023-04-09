package nguyenduc.springcommerce.services.Implement;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import nguyenduc.springcommerce.models.Cart;
import nguyenduc.springcommerce.repositories.CartRepo;
import nguyenduc.springcommerce.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImp implements CartService {
    @Autowired
    private CartRepo cartRepo;
    public void createCart(HttpServletRequest request, HttpServletResponse response){
        Cart tmp = this.getCart(request);
        if(tmp == null){
            boolean check = false;
            for (Cart c: cartRepo.findAll()) {
                if(c.getStatus() == 0){
                    Cookie cartCookie = new Cookie("cart", String.valueOf(c.getID()));
                    cartCookie.setMaxAge(30 * 24 * 60 * 60);
                    response.addCookie(cartCookie);
                    check = true;
                    break;
                }
            }
            if (check == false){
                Cart newCart = new Cart();
                cartRepo.save(newCart);
                Cookie cartCookie = new Cookie("cart", String.valueOf(newCart.getID()));
                cartCookie.setMaxAge(30 * 24 * 60 * 60);
                response.addCookie(cartCookie);
            }

        }
    }

    public Cart getCart(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        String cart = new String();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("cart")) {
                    cart = cookie.getValue();
                    return cartRepo.findCartByID(Integer.parseInt(cart));
                }
            }
        }
            return null;
    }

    public void removeCart(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        String cart = new String();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("cart")) {
                    cookie.setValue("");
                    cookie.setPath("/");
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
            }
        }

    }
}
