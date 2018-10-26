package com.yi.du.service.impl;

import com.yi.du.dao.StudentDao;
import com.yi.du.bean.Student;
import com.yi.du.service.StudentService;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by Administrator on 2018/2/26.
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentDao studentDao;
    @Override
    public int insert(Student student) {
        return studentDao.insert(student);
    }
    @Override
    public int insertSelective(Student student) {
        return studentDao.insertSelective(student);
    }
    @Override
    public Student selectById(Long id) {
        return studentDao.selectById(id);
    }
    @Override
    public List <Student> selectByCondition(Student student) {
        return studentDao.selectByCondition(student);
    }
    @Override
    public int updateById(Student student) {
        return studentDao.updateById(student);
    }
    @Override
    public Student selectByName(String name) {
        return studentDao.selectByName(name);
    }
    @Override
    public int updateByIdSelective(Student student) {
        return studentDao.updateByIdSelective(student);
    }
    @Override
    public int delectById(Student student) {
        return studentDao.deleteById(student);
    }
    @Override
    public int batchUpdate(List <Student> students) {
        return 0;
    }


    @Override
    public void export(String[] titles, ServletOutputStream out) throws Exception {
        try {

            /*
            * @workbook 创建一个Excel文件夹
            * @Sheet 创建一个纸张布
            * @Row 创建一个行数
            * @cellStyle设置单元格
            *
            *
            * */
            //第一步，创建一个workbook，对应一个的Excel文件
            HSSFWorkbook workbook=new HSSFWorkbook();
            //第二部，在sheet中添加一个sheet，对应Excel文件中的sheet
            HSSFSheet hssfSheet= workbook.createSheet("sheet1");
            //第三步，在sheet中添加表头第0行，注意老版本poi对Excel的行数列数有限制的short
            HSSFRow hssfRow=hssfSheet.createRow(0);
            //第四步，穿件单元格，并且设置值表头 设置表头居中
            HSSFCellStyle hssfCellStyle=workbook.createCellStyle();
            //居中样式
            hssfCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
            HSSFCell hssfCell=null;

            for (int i=0;i<titles.length;i++){
                hssfCell=hssfRow.createCell(i);//列索引从0开始
                hssfCell.setCellValue(titles[i]);//列名1
                hssfCell.setCellStyle(hssfCellStyle);//列居中显示
            }

            //第五步，写入实体数据
            List <Student> students=studentDao.query();
            SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-dd");
            if (students!=null&&students.isEmpty()){
                for (int i=0;i<students.size();i++){
                    hssfRow=hssfSheet.createRow(i+1);
                    Student student=students.get(i);
                    //第六步，创建单元格并设值

                   Long id= Long.valueOf(0);
                    if (student.getId()!=0){
                        id=student.getId();
                    }
                    hssfRow.createCell(0).setCellValue(id);
                    String username="";
                    if (student.getUsername()!=null){
                        username=student.getUsername();
                    }
                    hssfRow.createCell(1).setCellValue(username);
                    String password="";
                    if (student.getPassword(password)!=null){
                        password=student.getPassword(password);

                    }
                    hssfRow.createCell(2).setCellValue(password);


                }

            }

            //第七步，将文件输出到客户端浏览器
            try {
                workbook.write(out);
                out.flush();
                out.close();

            }catch (Exception e){
                e.printStackTrace();
            }



        }catch (Exception e){
            e.printStackTrace();
            throw  new Exception("导出信息失败");
        }

    }


}
