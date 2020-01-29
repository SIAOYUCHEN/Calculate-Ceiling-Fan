package com.example.admin.sunon_ceiling_fan;

import android.util.Log;

import java.util.Arrays;

/**
 * Created by admin on 2020/1/25.
 */

public class GlobalVariable{

    private static int length,width, fantype;
    private static boolean Area_Select[][] = new boolean[3][3];
    private static int [][]Area /*= new int[GetWidth()][GetLength()]*/;
    private static int Fill_Area_Width[][] = new int[3][3];
    private static int Fill_Area_Length[][] = new int[3][3];

    public void SetLength(int tmplength)
    {
        length = tmplength;
    }

    public void SetWidth(int tmpwidth)
    {
        width = tmpwidth;
    }

    public static int GetLength()
    {
        return length;
    }

    public static int GetWidth()
    {
        return width;
    }

    public void InitArea(int indexlength, int indexwidth)
    {
        Area = new int[indexlength][indexwidth];
    }

    public void SetArea(int indexlength, int indexwidth, int value)
    {
        Area[indexlength][indexwidth] = value;
    }

    public int GetArea(int indexlength, int indexwidth)
    {
        return Area[indexlength][indexwidth];
    }

    public void SetAreaSelect(int indexlength, int indexwidth)
    {
        Area_Select[indexlength][indexwidth] = true;
    }

    public Boolean GetAreaSelect(int indexlength, int indexwidth)
    {
        return Area_Select[indexlength][indexwidth];
    }

    public void ClearAreaSelect(int indexlength, int indexwidth)
    {
        Area_Select[indexlength][indexwidth] = false;
    }

    public void ClearAreaSelect()
    {
        for(int i = 0; i<3; i++)
        {
            for (int j = 0; j<3; j++)
            {
                Area_Select[i][j] = false;
            }
        }
    }

    public void SetFillWidthArea(int indexlength, int indexwidth, int value)
    {
        Fill_Area_Width[indexlength][indexwidth] = value;
    }

    public int GetFillWidthArea(int indexlength, int indexwidth)
    {
        return Fill_Area_Width[indexlength][indexwidth];
    }

    public void SetFillLengthArea(int indexlength, int indexwidth, int value)
    {
        Fill_Area_Length[indexlength][indexwidth] = value;
    }

    public int GetFillLengthArea(int indexlength, int indexwidth)
    {
        return Fill_Area_Length[indexlength][indexwidth];
    }

    public void SetFanType(int tmpfantype)
    {
        fantype = tmpfantype;
    }

    public int GetFanType()
    {
        return fantype;
    }
}
