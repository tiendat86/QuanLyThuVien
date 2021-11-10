/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.TaiLieu;
import model.TheBanDoc;

/**
 *
 * @author dangt
 */
public class main {
    public static void main(String[] args) throws ParseException {
           System.out.println(new PhieuMuonDAO().maxIDPhieuMuon());
    }
}
