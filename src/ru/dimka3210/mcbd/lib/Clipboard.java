package ru.dimka3210.mcbd.lib;

import java.awt.*;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;

/**
 * Created by dimka3210 on 10.10.14.
 * Support <dimka3210@gmail.com>
 */
public class Clipboard {
    private static java.awt.datatransfer.Clipboard clipboard = null;

    public static void addString(String str) {
        if (clipboard == null) {
            clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        }
        clipboard.setContents(new StringSelection(str), new ClipboardOwner() {
            @Override
            public void lostOwnership(java.awt.datatransfer.Clipboard clipboard, Transferable contents) {
            }
        });
    }
}