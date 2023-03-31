package com.rjsj.pethospital.util;

import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.FFmpegFrameRecorder;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.Java2DFrameUtils;
import org.bytedeco.opencv.opencv_core.IplImage;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

public class FileUtil {

    public static String fileParent = "E://res";

    public static String textWatermark = "虚拟宠物医院学习系统";

    public static String saveFile(String fileName, MultipartFile file) {
        if (file == null || Objects.equals(file.getOriginalFilename(), ""))
            return null;
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        File newFile = new File(FileUtil.fileParent, fileName + suffix);
        try {
            file.transferTo(newFile);
            if (FileUtil.isImage(newFile))
                FileUtil.addMark(newFile);
//            else if (FileUtil.isVideo(newFile))
//                FileUtil.videoAddMark(newFile);
            return newFile.getName();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void removeFile(String fileName) {
        File file = new File(FileUtil.fileParent, fileName);
        if (file.exists())
            file.delete();
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

    public static boolean isVideo(File file) {
        String suffix = file.getName().substring(file.getName().lastIndexOf(".") + 1);
        switch (suffix) {
            case "mp4":
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

    public static void videoAddMark(File file) throws IOException {
        FFmpegFrameGrabber frameGrabber = new FFmpegFrameGrabber(file);
        try {
            frameGrabber.start();
            String fileName = FileUtil.fileParent + File.separator + "test.mp4";
            System.out.println("文件名-->>" + fileName);
            FFmpegFrameRecorder recorder = new FFmpegFrameRecorder(fileName, frameGrabber.getImageWidth(), frameGrabber.getImageHeight(), frameGrabber.getAudioChannels());
            recorder.setSampleRate(frameGrabber.getSampleRate());
            recorder.setFrameRate(frameGrabber.getFrameRate());
            recorder.setTimestamp(frameGrabber.getTimestamp());
            recorder.setVideoBitrate(frameGrabber.getVideoBitrate());
            recorder.setVideoCodec(frameGrabber.getVideoCodec());

            Frame frame;
            recorder.start();
            int index = 0;
            while (true) {
                frame = frameGrabber.grabFrame();
                if (frame == null) {
                    System.out.println("视频处理完成");
                    break;
                }
                //判断音频
                System.out.println("音频 == " + (frame.samples == null) + ", 视频 == " + (frame.image == null));
                //判断图片帧
                if (frame.image != null) {
                    IplImage iplImage = Java2DFrameUtils.toIplImage(frame);
                    BufferedImage buffImg = Java2DFrameUtils.toBufferedImage(iplImage);
                    Graphics2D graphics2D = buffImg.createGraphics();

                    graphics2D.setColor(new Color(255, 255, 255, 128));
                    graphics2D.setFont(new Font("微软雅黑", Font.BOLD, 30));
                    int x = (iplImage.width() - getWatermarkLength(textWatermark, graphics2D)) / 2;
                    int y = iplImage.height() / 2;
                    graphics2D.drawString(textWatermark, x, y);
                    graphics2D.dispose();

                    Frame newFrame = Java2DFrameUtils.toFrame(buffImg);
                    recorder.record(newFrame);
                }
                //设置音频
                if (frame.samples != null) {
                    recorder.recordSamples(frame.sampleRate, frame.audioChannels, frame.samples);
                }
                if (index % 20 == 0)
                    System.out.println("帧值 = " + index);
                index++;
            }

            recorder.stop();
            recorder.release();
            frameGrabber.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int getWatermarkLength(String waterMarkContent, Graphics2D graphics2D) {
        return graphics2D.getFontMetrics(graphics2D.getFont()).charsWidth(waterMarkContent.toCharArray(), 0, waterMarkContent.length());
    }

}
