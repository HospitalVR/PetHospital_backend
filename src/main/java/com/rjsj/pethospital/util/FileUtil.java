package com.rjsj.pethospital.util;

import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

public class FileUtil {

    public static String saveFile(String fileName, MultipartFile file) {
        if (file == null || Objects.equals(file.getOriginalFilename(), ""))
            return null;
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        File newFile = new File("E:/res", fileName + suffix);
        try {
            file.transferTo(newFile);
            if (FileUtil.isImage(newFile))
                FileUtil.addMark(newFile);
            return newFile.getName();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static boolean isImage(File file) {
        String suffix = file.getName().substring(file.getName().lastIndexOf(".") + 1);
        switch (suffix) {
            case "jpg":
            case "png":
                return true;
        }
        return false;
    }

    public static void addMark(File file) throws IOException {
        Image srcImg = ImageIO.read(file);
        int srcImgWidth = srcImg.getWidth(null);
        int srcImgHeight = srcImg.getHeight(null);
        System.out.println("图片的宽:" + srcImgWidth);
        System.out.println("图片的高:" + srcImgHeight);

        BufferedImage bufImg = new BufferedImage(srcImgWidth, srcImgHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = bufImg.createGraphics();
        graphics2D.drawImage(srcImg, 0, 0, srcImgWidth, srcImgHeight, null);

        String textWatermark = "虚拟宠物医院学习系统";

        graphics2D.setColor(new Color(255, 255, 255, 128));
        graphics2D.setFont(new Font("微软雅黑", Font.BOLD, 30));
        int x = (srcImgWidth - getWatermarkLength(textWatermark, graphics2D)) / 2;
        int y = srcImgHeight / 2;
        graphics2D.drawString(textWatermark, x, y);
        graphics2D.dispose();

        String tarImgPath = file.getPath();
        String format = file.getName().substring(file.getName().lastIndexOf(".") + 1);
        FileOutputStream outImgStream = new FileOutputStream(tarImgPath);
        ImageIO.write(bufImg, format, outImgStream);
        System.out.println("添加水印完成");
        outImgStream.flush();
        outImgStream.close();
    }

    public static int getWatermarkLength(String waterMarkContent, Graphics2D graphics2D) {
        return graphics2D.getFontMetrics(graphics2D.getFont()).charsWidth(waterMarkContent.toCharArray(), 0, waterMarkContent.length());
    }

}
