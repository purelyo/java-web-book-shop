package com.lyy.Web;

import com.alipay.api.AlipayApiException;
import com.alipay.api.domain.Product;
import com.alipay.api.internal.util.AlipaySignature;
import com.lyy.pay.AlipayConfig;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @description:
 * @author: Moon
 */

public class NotifyServlet extends BaseServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String,String[]> parameterMap=request.getParameterMap();

        //业务处理
        for(String key : parameterMap.keySet()) {
            System.out.println("KEY:"+key+"--value:"+parameterMap.get(key));
        }
        //成功处理后返回success
        response.getWriter().write("success");
    }

//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("支付成功, 进入异步通知接口...");
//
//        //获取支付宝POST过来反馈信息
//        Map<String, String> params = new HashMap<String, String>();
//        Map<String, String[]> requestParams = req.getParameterMap();
//        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
//            String name = (String) iter.next();
//            String[] values = (String[]) requestParams.get(name);
//            String valueStr = "";
//            for (int i = 0; i < values.length; i++) {
//                valueStr = (i == values.length - 1) ? valueStr + values[i]
//                        : valueStr + values[i] + ",";
//            }
//            //乱码解决，这段代码在出现乱码时使用
////			valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
//            params.put(name, valueStr);
//        }
//
//        boolean signVerified = false; //调用SDK验证签名
//        try {
//            signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type);
//        } catch (AlipayApiException e) {
//            e.printStackTrace();
//        }
//
//        //——请在这里编写您的程序（以下代码仅作参考）——
//
//		/* 实际验证过程建议商户务必添加以下校验：
//		1、需要验证该通知数据中的out_trade_no是否为商户系统中创建的订单号，
//		2、判断total_amount是否确实为该订单的实际金额（即商户订单创建时的金额），
//		3、校验通知中的seller_id（或者seller_email) 是否为out_trade_no这笔单据的对应的操作方（有的时候，一个商户可能有多个seller_id/seller_email）
//		4、验证app_id是否为该商户本身。
//		*/
//        if (signVerified) {//验证成功
//            //商户订单号
//            String out_trade_no = new String(req.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");
//
//            //支付宝交易号
//            String trade_no = new String(req.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");
//
//            //交易状态
//            String trade_status = new String(req.getParameter("trade_status").getBytes("ISO-8859-1"), "UTF-8");
//
//            //付款金额
//            String total_amount = new String(req.getParameter("total_amount").getBytes("ISO-8859-1"), "UTF-8");
//
//            if (trade_status.equals("TRADE_FINISHED")) {
//                //判断该笔订单是否在商户网站中已经做过处理
//                //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
//                //如果有做过处理，不执行商户的业务程序
//
//                //注意： 尚自习的订单没有退款功能, 这个条件判断是进不来的, 所以此处不必写代码
//                //退款日期超过可退款期限后（如三个月可退款），支付宝系统发送该交易状态通知
//            } else if (trade_status.equals("TRADE_SUCCESS")) {
//                //判断该笔订单是否在商户网站中已经做过处理
//                //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
//                //如果有做过处理，不执行商户的业务程序
//
//                //注意：
//                //付款完成后，支付宝系统发送该交易状态通知
//                // 修改叮当状态，改为 支付成功，已付款; 同时新增支付流水
//            }
//            System.out.println("支付成功...");
//
//        } else {//验证失败
//            System.out.println("支付, 验签失败...");
//        }
//    }
}
