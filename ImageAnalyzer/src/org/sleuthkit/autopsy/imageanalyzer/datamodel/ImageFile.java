/*
 * Autopsy Forensic Browser
 *
 * Copyright 2013 Basis Technology Corp.
 * Contact: carrier <at> sleuthkit <dot> org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.sleuthkit.autopsy.imageanalyzer.datamodel;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.util.logging.Level;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javax.imageio.ImageIO;
import org.sleuthkit.autopsy.coreutils.Logger;
import org.sleuthkit.autopsy.imageanalyzer.ThumbnailCache;
import org.sleuthkit.datamodel.AbstractFile;
import org.sleuthkit.datamodel.ReadContentInputStream;

/**
 * ImageAnalyzer data model object that represents an image file. It is a
 * wrapper(/decorator?/adapter?) around {@link AbstractFile} and provides
 * methods to get an icon sized and a full sized {@link  Image}.
 *
 *
 */
public class ImageFile<T extends AbstractFile> extends DrawableFile<T> {

    private SoftReference<Image> imageRef;

    ImageFile(T f, Boolean analyzed) {
        super(f, analyzed);

    }

    @Override
    public Image getThumbnail() {
        return ThumbnailCache.getDefault().get(this);
    }

   

    public Image getFullSizeImage() {
        Image image = null;
        if (imageRef != null) {
            image = imageRef.get();
        }

        if (image == null) {

            try (ReadContentInputStream readContentInputStream = new ReadContentInputStream(this.getAbstractFile())) {
                BufferedImage read = ImageIO.read(readContentInputStream);
                image = SwingFXUtils.toFXImage(read, null);
            } catch (IOException | NullPointerException ex) {
                Logger.getLogger(ImageFile.class.getName()).log(Level.WARNING, "unable to read file" + getName());
                return null;
            }
            imageRef = new SoftReference<>(image);
        }
        return image;
    }

    @Override
    Double getWidth() {
        final Image fullSizeImage = getFullSizeImage();
        if (fullSizeImage != null) {
            return fullSizeImage.getWidth();
        }
        return -1.0;
    }

    @Override
    Double getHeight() {
        final Image fullSizeImage = getFullSizeImage();
        if (fullSizeImage != null) {
            return fullSizeImage.getHeight();
        }
        return -1.0;
    }

    @Override
    public boolean isVideo() {
        return false;
    }
 }
