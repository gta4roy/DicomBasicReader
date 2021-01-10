package com.gta4roy.dicom.reader;

import com.pixelmed.dicom.Attribute;
import com.pixelmed.dicom.AttributeList;
import com.pixelmed.dicom.AttributeTag;
import com.pixelmed.dicom.TagFromName;

public class DicomReader {
    private static AttributeList list = new AttributeList();

    public static void main(String[] args) {
        String dicomFile = "/home/pi/Projects/dicom/CT-Thorax-Abdomen/IM-0001-0001.dcm";
        try {
            list.read(dicomFile);
            System.out.println("Study Instance UID:" + getTagInformation(TagFromName.StudyInstanceUID));
            System.out.println("Series Instance UID:" + getTagInformation(TagFromName.SeriesInstanceUID));
            System.out.println("SOP Class UID:" + getTagInformation(TagFromName.SOPClassUID));
            System.out.println("SOP Instance UID:" + getTagInformation(TagFromName.SOPInstanceUID));
            System.out.println("Transfer Syntax UID:" + getTagInformation(TagFromName.TransferSyntaxUID));
            System.out.println("Accession No:" + getTagInformation(TagFromName.AccessionNumber));

        } catch (Exception e) {
            e.printStackTrace(); //in real life, do something about this exception
        }
    }

    private static String getTagInformation(AttributeTag attrTag) {
        return Attribute.getDelimitedStringValuesOrEmptyString(list, attrTag);
    }

}
