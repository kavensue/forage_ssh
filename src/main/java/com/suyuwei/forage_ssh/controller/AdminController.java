package com.suyuwei.forage_ssh.controller;

import com.suyuwei.forage_ssh.dao.ForageInfomationJPA;
import com.suyuwei.forage_ssh.entity.ForageEntity;
import com.suyuwei.forage_ssh.entity.ForageInfomationEntity;
import com.suyuwei.forage_ssh.entity.ForageStoreEntity;
import com.suyuwei.forage_ssh.service.ForageInfomationService;
import com.suyuwei.forage_ssh.service.ForageService;
import com.suyuwei.forage_ssh.service.ForageStoreService;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private ForageService forageService;
    @Autowired
    private ForageStoreService forageStoreService;
    @Autowired
    private ForageInfomationService forageInfomationService;

    //饲料属性添加
    @RequestMapping(value = "/forageAdd",method = RequestMethod.POST)
    @ResponseBody
    public int forageAdd(HttpServletRequest request,HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        response.setHeader("Access-Control-Allow-Origin","*");
        return forageService.forageListAdd(request);
    }

    //饲料属性删除
    @RequestMapping(value = "/forageDelete",method = RequestMethod.GET)
    @ResponseBody
    public int forageDelete(HttpServletRequest request,HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        response.setHeader("Access-Control-Allow-Origin","*");
        return forageService.forageListDelete(request);
    }

    //饲料属性查询
    @RequestMapping(value = "/forageGet",method = RequestMethod.GET)
    @ResponseBody
    public List<ForageEntity> forageGet(HttpServletRequest request, HttpServletResponse response){
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        response.setHeader("Access-Control-Allow-Origin","*");
        return forageService.forageListGet(request);
    }

    //饲料属性更新
    @RequestMapping(value = "/forageUpdate",method = RequestMethod.POST)
    @ResponseBody
    public int forageUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        response.setHeader("Access-Control-Allow-Origin","*");
        return forageService.forageListUpdate(request);
    }



    //饲料储量和入库信息增加
    @RequestMapping(value = "/forageStoreAndInfoSave",method = RequestMethod.POST)
    @ResponseBody
    public int forageStoreAndInfoSave(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        response.setHeader("Access-Control-Allow-Origin","*");
        return forageInfomationService.forageInfomationAdd(request);
    }

    //饲料储量删除
    @RequestMapping(value = "/forageStoreDelete",method = RequestMethod.GET)
    @ResponseBody
    public int forageStoreDelete(HttpServletRequest request,HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        response.setHeader("Access-Control-Allow-Origin","*");
        return forageStoreService.forageStoreDelete(request);
    }

    //饲料储量查询
    @RequestMapping(value = "/forageStoreGet",method = RequestMethod.GET)
    @ResponseBody
    public List<ForageStoreEntity> forageStoreGet(HttpServletResponse response){
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        response.setHeader("Access-Control-Allow-Origin","*");
        return forageStoreService.forageStoreGet();
    }

    //饲料储量更新，人工的
    @RequestMapping(value = "/forageStoreUpdate",method = RequestMethod.POST)
    @ResponseBody
    public int forageStoreUpdate(HttpServletRequest request,HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        response.setHeader("Access-Control-Allow-Origin","*");
        return forageStoreService.forageStoreUpdate(request);
    }



    //饲料出入库信息删除
    @RequestMapping(value = "/forageInfomationDelete",method = RequestMethod.GET)
    @ResponseBody
    public int forageInfomationDelete(HttpServletRequest request,HttpServletResponse response){
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        response.setHeader("Access-Control-Allow-Origin","*");
        return forageInfomationService.forageInfomationDelete(request);
    }

    //饲料出入库信息查询
    @RequestMapping(value = "/forageInfomationGet",method = RequestMethod.GET)
    @ResponseBody
    public List<ForageInfomationEntity> forageInfomationGet(HttpServletResponse response){
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        response.setHeader("Access-Control-Allow-Origin","*");
        return forageInfomationService.forageInfomationGet();
    }

    //饲料出库信息（饲料发放）增加
    @RequestMapping(value = "/forageProvideInfo",method = RequestMethod.POST)
    @ResponseBody
    public int forageProvideInfo(HttpServletRequest request,HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        response.setHeader("Access-Control-Allow-Origin","*");
        return forageInfomationService.forageProvideInfo(request);
    }



    @Autowired
    private ForageInfomationJPA forageInfomationJPA;
    //打印全部的饲料出入库流水账
    @RequestMapping(value = "/download")
    public void downloadForageInfoList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String[] headers={"饲料流水号","饲料种类","饲料数量","饲料单位","饲料出入库时间","仓库管理员姓名","饲养人员姓名"};
        List<ForageInfomationEntity> forageInfomationEntityList=forageInfomationJPA.findAll();

        //声明一个工作簿
        HSSFWorkbook workbook=new HSSFWorkbook();
        //生成一个表格
        HSSFSheet sheet=workbook.createSheet();
        //设置表格默认列宽度为15个字节
        sheet.setDefaultColumnWidth((short) 18);
        HSSFRow row=sheet.createRow(0);
        for(short i=0;i<headers.length;i++){
            HSSFCell cell=row.createCell(i);
            HSSFRichTextString text=new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }
        //遍历集合数据，产生数据行
        Iterator it=forageInfomationEntityList.iterator();
        int index=0;
        while(it.hasNext()){
            index++;
            row=sheet.createRow(index);
            ForageInfomationEntity t=(ForageInfomationEntity)it.next();
            //利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
            Field[] fields=t.getClass().getDeclaredFields();
            for(short i=0;i<fields.length;i++){
                HSSFCell cell=row.createCell(i);
                Field field = fields[i];
                String fieldName = field.getName();
                String getMethodName = "get"+ fieldName.substring(0, 1).toUpperCase()+ fieldName.substring(1);
                try{
                    Class tCls=t.getClass();
                    Method getMethod=tCls.getMethod(getMethodName,
                            new Class[]{});
                    Object value=getMethod.invoke(t,new Object[]{});
                    String textValue = null;

                    if (value instanceof Date){
                        Date date = (Date) value;
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        textValue = sdf.format(date);
                    }else if(value == null) {
                        textValue="无";
                    }else {
                        //其它数据类型都当作字符串简单处理
                        textValue = value.toString();
                    }
                    HSSFRichTextString richString = new HSSFRichTextString(textValue);
                    HSSFFont font3 = workbook.createFont();
                    font3.setColor(HSSFColor.BLUE.index);//定义Excel数据颜色
                    richString.applyFont(font3);
                    cell.setCellValue(richString);
                }catch (SecurityException e){
                    e.printStackTrace();
                }catch (NoSuchMethodException e){
                    e.printStackTrace();
                }catch (IllegalArgumentException e){
                    e.printStackTrace();
                }catch (IllegalAccessException e){
                    e.printStackTrace();
                }catch (InvocationTargetException e){
                    e.printStackTrace();
                }
            }
        }
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=createList.xls");//默认Excel名称
        response.flushBuffer();
        workbook.write(response.getOutputStream());
    }
}
