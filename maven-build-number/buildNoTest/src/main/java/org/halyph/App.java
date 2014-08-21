package org.halyph;

import java.io.IOException;
import java.util.ResourceBundle;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

public class App
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println("Verify Resource bundle" );
		
		// Check filtered resources based on generated build number
        ResourceBundle bundle = ResourceBundle.getBundle( "build" );
        String msg = bundle.getString( "build.message" );
        System.out.println(msg);

        System.out.println("\nVerify Generated MANIFEST.MF Properties" );

		// Check Manifest file based on generated build number
        Manifest mf = new Manifest();
        mf.read(Thread.currentThread().getContextClassLoader().getResourceAsStream("META-INF/MANIFEST.MF"));

        Attributes atts = mf.getMainAttributes();

        System.out.println("Implementation-Versio: " + atts.getValue("Implementation-Version"));
        System.out.println("Implementation-Build: " + atts.getValue("Implementation-Build"));
    }
}
