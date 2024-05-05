package list;/**
 * 作者:灰爪哇
 * 时间:2024-03-18
 */

import org.marc4j.MarcReader;
import org.marc4j.MarcStreamReader;
import org.marc4j.marc.DataField;
import org.marc4j.marc.Record;
import org.marc4j.marc.Subfield;
import org.marc4j.marc.VariableField;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author: Hui
 **/
public class ReaderisoFILe {
    public static void main(String[] args) {
            try {
                // 打开ISO文件输入流
                FileInputStream fis = new FileInputStream("D:\\编目ISO\\2403-001_19-010.ISO");

                // 创建Iso2709Reader对象
                MarcReader reader = new MarcStreamReader(fis,"GBK");

                // 逐个读取记录
                while (reader.hasNext()) {
                    // 读取下一条记录
                    Record record = reader.next();
                    System.out.println(record.toString());
                    // 提取标题信息
                    VariableField titleField = record.getVariableField("200");//根据需要改变编号
                    if (titleField instanceof DataField) {
                        DataField dataField = (DataField) titleField;
                        Subfield subfield = dataField.getSubfield('a');
                        String title = subfield != null ? subfield.getData() : "";
                        System.out.println("Title: " + title);
                    }

                    // 提取作者信息
                    VariableField authorField = record.getVariableField("701");//根据需要改变编号
                    if (authorField instanceof DataField) {
                        DataField dataField = (DataField) authorField;
                        Subfield subfield = dataField.getSubfield('a');
                        String author = subfield != null ? subfield.getData() : "";
                        System.out.println("Author: " + author);
                    }

                    // 提取出版商和出版日期信息
                    VariableField publisherField = record.getVariableField("801");//根据需要改变编号
                    if (publisherField instanceof DataField) {
                        DataField dataField = (DataField) publisherField;
                        Subfield publisherSubfield = dataField.getSubfield('b');
                        String publisher = publisherSubfield != null ? publisherSubfield.getData() : "";

                        Subfield dateSubfield = dataField.getSubfield('c');
                        String date = dateSubfield != null ? dateSubfield.getData() : "";

                        System.out.println("Publisher: " + publisher);
                        System.out.println("Date: " + date);
                    }

                    // 提取主题词和主题分类号
                    VariableField subjectField = record.getVariableField("690");//根据需要改变编号
                    if (subjectField instanceof DataField) {
                        DataField dataField = (DataField) subjectField;
                        Subfield subfield = dataField.getSubfield('a');
                        String subject = subfield != null ? subfield.getData() : "";
                        System.out.println("Subject: " + subject);
                    }

                    // 提取ISBN号码
                    VariableField isbnField = record.getVariableField("010");//根据需要改变编号
                    if (isbnField instanceof DataField) {
                        DataField dataField = (DataField) isbnField;
                        Subfield subfield = dataField.getSubfield('a');
                        String isbn = subfield != null ? subfield.getData() : "";
                        System.out.println("ISBN: " + isbn);
                    }
                    //简介
                    VariableField contextField = record.getVariableField("330");
                    if (contextField instanceof DataField) {
                        DataField dataField = (DataField) contextField;
                        Subfield subfield = dataField.getSubfield('a');
                        String context = subfield != null ? subfield.getData() : "";
                        System.out.println("context: " + context);
                    }

                }

                // 关闭输入流
                fis.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}
