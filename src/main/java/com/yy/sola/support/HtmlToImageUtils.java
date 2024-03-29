package com.yy.sola.support;



import org.apache.tomcat.util.http.fileupload.FileUtils;
import sun.misc.BASE64Decoder;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicEditorPaneUI;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.UUID;

/**
 * @author: sunwei
 * @date: 2019-09-17
 * @time: 19:14
 * @description:
 */
public class HtmlToImageUtils {
    public static int DEFAULT_IMAGE_WIDTH = 1200;
    public static int DEFAULT_IMAGE_HEIGHT = 700;
    public static boolean paintPage(Graphics g, int hPage, int pageIndex, JTextPane panel) {
        Graphics2D g2 = (Graphics2D) g;
        Dimension d = ((BasicEditorPaneUI) panel.getUI()).getPreferredSize(panel);
        double panelHeight = d.height;
        double pageHeight = hPage;
        int totalNumPages = (int) Math.ceil(panelHeight / pageHeight);
        g2.translate(0f, -(pageIndex - 1) * pageHeight);
        panel.paint(g2);
        boolean ret = true;

        if (pageIndex >= totalNumPages) {
            ret = false;
            return ret;
        }
        return ret;
    }

    /**
     * html转换为ｊｐｅｇ文件
     *
     * @param bgColor
     *            图片的背景色
     * @param html
     *            html的文本信息
     * @param width
     *            显示图片的Ｔｅｘｔ容器的宽度
     * @param height
     *            显示图片的Ｔｅｘｔ容器的高度
     * @param eb
     *            設置容器的边框
     * @return
     * @throws Exception
     */
    @SuppressWarnings("restriction")
    public static byte[] html2jpeg(Color bgColor, String html, int width,
                                   int height, EmptyBorder eb) throws Exception {
        String imageName = "E:\\"+ UUID.randomUUID().toString() + ".jpg";
        JTextPane tp = new JTextPane();
        tp.setSize(width, height);
        if (eb == null) {
            eb = new EmptyBorder(0, 50, 0, 50);
        }
        if (bgColor != null) {
            tp.setBackground(bgColor);
        }
        if (width <= 0) {
            width = DEFAULT_IMAGE_WIDTH;
        }
        if (height <= 0) {
            height = DEFAULT_IMAGE_HEIGHT;
        }
        tp.setBorder(eb);
        tp.setContentType("text/html");
        tp.setText(html);

        int pageIndex = 1;
        boolean bcontinue = true;
        String resUrl = "";
        byte[] bytes = null;
        while (bcontinue) {
            BufferedImage image = new BufferedImage(width,
                    height, BufferedImage.TYPE_INT_RGB);
            Graphics g = image.getGraphics();
            g.setClip(0, 0, width, height);
            bcontinue = paintPage(g, height, pageIndex, tp);
            g.dispose();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(image, "jpg", baos);

            baos.flush();
            bytes = baos.toByteArray();
            baos.close();
            //FileUtils.writeByteArrayToFile(new File(imageName), bytes);
            //写入阿里云
            pageIndex++;
        }
        return bytes;
    }

    public static void main(String[] args) {
        String htmlstr = ""+"<body style=\"background:#f4f4f4;margin:0;padding:0;font-size:14px;color:#333;line-height: 1;box-sizing:border-box;\">" +
                "<div  style=\"box-sizing:border-box;width:980px;padding: 32px 40px;overflow: hidden;margin:0 auto;\">" +
                "<div style=\"box-sizing:border-box;text-align: right;width:100%;height:16px;font-size: 16px;line-height: 16px;\">住院</div>" +
                "<div style=\"box-sizing:border-box;width:100%;height:60px;line-height: 1;overflow:hidden;text-align: center;\">" +
                "<div style=\"box-sizing:border-box;display: inline-block;margin:0 auto;\">" +
                "<div style=\"box-sizing:border-box;display:block;font-size: 24px;\">首都医科大学附属北京儿童医院</div>" +
                "<div style=\"box-sizing:border-box;display:block;font-size: 20px;margin-top:16px;\">影像检查诊断报告单</div>" +
                "</div>" +
                "</div>" +
                "<div style=\"box-sizing:border-box;width:100%;border:solid 2px #000;border-right:none;border-left:none; line-height:28px;height:62px;margin-top:10px;padding:2px 8px;\">" +
                "<table border=\"0\" style=\"width:100%;border-spacing:0px ; \">" +
                "<tr style=\"width:100%;height:16px;\" border=\"0\">" +
                "<td style=\"width:25%;\">姓名：张三丰</td>" +
                "<td style=\"width:25%;\">性别：男</td>" +
                "<td style=\"width:25%;\">年龄：4岁</td>" +
                "<td style=\"width:25%;\">ID号：  0009090990</td>" +
                "</tr>" +
                "<tr style=\"width:100%;height:16px;\" border=\"0\">" +
                "<td style=\"\">科室：内分泌</td>" +
                "<td style=\"width:25%;\">HIS号：987922</td>" +
                "<td style=\"width:25%;\">检查类别：MR</td>" +
                "<td style=\"width:25%;\">检验号：201209090909</td>" +
                "</tr>" +
                "</table>" +
                "</div>" +
                "<div style=\"min-height:30px;clear:both;overflow:hidden;margin-top:8px;\">" +
                "<table border=\"0\" style=\"width:100%;border-spacing:0px ; \">" +
                "<tr style=\"width:100%;height:16px;\" border=\"0\">" +
                "<td style=\"width:90px;font-size: 16px;line-height:24px;color:#000;font-weight:700;\">检查部位：</td>" +
                "<td style=\"width:810px;padding-left:8px;line-height:20px;padding-top:2px;\">小腿哦UI电话小腿小腿哦U话小腿哦UI电话</td>" +
                "</tr>" +
                "</table>" +
                "</div>" +
                "<div style=\"min-height:100px;clear:both;overflow:hidden;margin-top:20px;\">" +
                "<table border=\"0\" style=\"width:100%;border-spacing:0px ; \">" +
                "<tr style=\"width:100%;\" border=\"0\" valign=\"top\">" +
                "<td style=\"width:90px;font-size: 16px;line-height:24px;color:#000;font-weight:700;\">影像表现：</td>" +
                "<td style=\"width:810px;padding-left:8px;line-height:20px;padding-top:2px;\">小腿哦UI电话小腿哦UI电话小腿哦UI电话小腿哦UIUI电话小腿哦UI电话小腿哦UI电话小腿哦UI电话小腿哦UI电话小腿哦UI电话小腿哦UI电话小腿哦UI电话小腿哦UI电话小腿哦UI电话小腿哦UIUI电话小腿哦UI电话小腿哦UI电话小腿哦UI电话小腿哦UI电话小腿哦UI电话小腿哦UI电话小腿哦UI电话小腿哦UI电话小腿哦UI电话小腿哦UI电话小腿哦UI电话小腿哦UI电话小腿哦UI电话小腿哦UI电话小腿哦UI电话小腿哦UI电话小腿哦UI电话小腿哦UI电话小腿哦UI电话小腿哦UI电话小腿哦UI电话小腿哦UI电话</td>" +
                "</tr>" +
                "</table>" +
                "</div>" +
                "<div style=\"min-height:100px;clear:both;overflow:hidden;margin-top:30px;\">" +
                "<table border=\"0\" style=\"width:100%;border-spacing:0px ; \">" +
                "<tr style=\"width:100%;\" border=\"0\" valign=\"top\">" +
                "<td style=\"width:90px;font-size: 16px;line-height:24px;color:#000;font-weight:700;\">印象：</td>" +
                "<td style=\"width:810px;padding-left:8px;line-height:20px;padding-top:2px;\">小腿哦UI电话小腿哦UI电话小腿哦UI电话小腿哦UIUI电话小腿哦UI电话小腿哦UI电话小腿哦UI电话小腿哦UI电话小腿哦UI电话小腿哦UI电话小腿哦UI电话小腿哦UI电话小腿哦UI电话小腿哦UIUI电话小腿哦UI电话小腿哦UI电话小腿哦UI电话小腿哦UI电话小腿哦UI电话小腿哦UI电话小腿哦UI电话小腿哦UI电话小腿哦UI电话小腿哦UI电话小腿哦UI电话小腿哦UI电话小腿哦UI电话小腿哦UI电话小腿哦UI电话小腿哦UI电话小腿哦UI电话小腿哦UI电话小腿哦UI电话小腿哦UI电话小腿哦UI电话小腿哦UI电话</td>" +
                "</tr>" +
                "</table>" +
                "</div>" +
                "<div style=\"margin-top:20px;height:24px;line-height:24px;\">" +
                "<table border=\"0\" style=\"width:100%;border-spacing:0px ; \">" +
                "<tr style=\"width:100%;height:24x;\" border=\"0\">" +
                "<td style=\"width:36%;\">报告日期：2017-11-22 11:12:09</td>" +
                "<td style=\"width:34%;\">报告医生：唐小小</td>" +
                "<td style=\"\">审核医生：李若曦</td>" +
                "</tr>" +
                "</table>" +
                "</div>" +
                "<div style=\"border-top:solid 2px #000;margin-top:6px;font-size:10px;font-weight:600;line-height:26px;padding-left:10px;\">  " +
                "注：本报告仅供临床医师参考，影像科医师签字 后生效" +
                "</div>" +
                "" +
                "</div>" +
                "</body>";
        try {
            byte[] bytes = HtmlToImageUtils.html2jpeg(Color.white, htmlstr,
                    1300, 1200, new EmptyBorder(0, 0,
                            0, 0));
            OutputStream os = new FileOutputStream("D:\\ss.png");
            os.write(bytes, 0, bytes.length);
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }



    }

}
