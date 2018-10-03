package com.util;

import com.pojo.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author: hokitlee
 * @description:
 * @create: 2018-09-18 10:21
 **/
public class JwtUtil {
    /**
     * 创建jwt
     * @param id
     * @param
     * @param ttlMillis 过期的时间长度
     * @return
     * @throws Exception
     */
    public static String createJWT(String id, Map claims, long ttlMillis) throws Exception {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256; //指定签名的时候使用的签名算法，也就是header那部分，jjwt已经将这部分内容封装好了。
        long nowMillis = System.currentTimeMillis();//生成JWT的时间
        Date now = new Date(nowMillis);
//        Map<String,Object> claims = new HashMap<String,Object>();//创建payload的私有声明（根据特定的业务需要添加，如果要拿这个做验证，一般是需要和jwt的接收方提前沟通好验证方式的）
//        claims.put("uid", "DSSFAWDWADAS...");
//        claims.put("user_name", "admin");
//        claims.put("nick_name","DASDA121");
        String subject = "user";
        SecretKey key = generalKey();//生成签名的时候使用的秘钥secret,这个方法本地封装了的，一般可以从本地配置文件中读取，切记这个秘钥不能外露哦。它就是你服务端的私钥，在任何场景都不应该流露出去。一旦客户端得知这个secret, 那就意味着客户端是可以自我签发jwt了。
        //下面就是在为payload添加各种标准声明和私有声明了
        JwtBuilder builder = Jwts.builder() //这里其实就是new一个JwtBuilder，设置jwt的body
                .setClaims(claims)          //如果有私有声明，一定要先设置这个自己创建的私有的声明，这个是给builder的claim赋值，一旦写在标准的声明赋值之后，就是覆盖了那些标准的声明的
                .setId(id)                  //设置jti(JWT ID)：是JWT的唯一标识，根据业务需要，这个可以设置为一个不重复的值，主要用来作为一次性token,从而回避重放攻击。
                .setIssuedAt(now)           //iat: jwt的签发时间
                .setSubject(subject)        //sub(Subject)：代表这个JWT的主体，即它的所有人，这个是一个json格式的字符串，可以存放什么userid，roldid之类的，作为什么用户的唯一标志。
                .signWith(key);//设置签名使用的签名算法和签名使用的秘钥
//                .signWith(SignatureAlgorithm.HS512, "MyJwtSecret")
        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);     //设置过期时间
       }
        return builder.compact();           //就开始压缩为xxxxxxxxxxxxxx.xxxxxxxxxxxxxxx.xxxxxxxxxxxxx这样的jwt
    }

    /**
     * 由字符串生成加密key
     * @return
     */
    public static SecretKey generalKey(){
//        String stringKey = "7786df7fc3a34e26a61c034d5ec8245dasdfasdfasdf";//本地配置文件中加密的密文7786df7fc3a34e26a61c034d5ec8245d
//        byte[] encodedKey = Base64.base64ToByteArray(stringKey);//本地的密码解码[B@152f6e2
////        System.out.println(encodedKey);//[B@152f6e2
//        System.out.println(encodedKey.length);
////        System.out.println(Base64.byteArrayToAltBase64(encodedKey));//7786df7fc3a34e26a61c034d5ec8245d
//        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");// 根据给定的字节数组使用AES加密算法构造一个密钥，使用 encodedKey中的始于且包含 0 到前 leng 个字节这是当然是所有。（后面的文章中马上回推出讲解Java加密和解密的一些算法）

        SecretKey key = new SecretKeySpec("7786df7fc3a34e26a61c034d5ec8245dasdfasdfasdf".getBytes(),
                SignatureAlgorithm.HS512.getJcaName());
        return key;
    }

    /**
     * 解密jwt
     * @param jwt
     * @return
     * @throws Exception
     */
    public static Claims parseJWT(String jwt) throws Exception{
        SecretKey key = generalKey();  //签名秘钥，和生成的签名的秘钥一模一样
        Claims claims = Jwts.parser()  //得到DefaultJwtParser
                .setSigningKey(key)         //设置签名的秘钥
                .parseClaimsJws(jwt).getBody();//设置需要解析的jwt
        return claims;
    }

    static Authentication getAuthentication(HttpServletRequest request, User user,String authoritie ){

        List<GrantedAuthority> authorities =  AuthorityUtils.commaSeparatedStringToAuthorityList((String) authoritie);
        return user != null ?
                new UsernamePasswordAuthenticationToken(user.getUsername(), null, authorities) :
                null;
    }

    static void addAuthentication(HttpServletResponse response, String token) {
        Cookie cookie = new javax.servlet.http.Cookie("token",token);
        cookie.setMaxAge(60*30);
        cookie.setPath("/");
        response.addCookie(cookie);
    }
}
