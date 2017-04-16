import java.util.HashMap;
import java.util.Map;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.Buffer;
import java.util.*;
import java.io.File;
import javax.imageio.ImageIO;

/**
 * This class provides all code necessary to take a query box and produce
 * a query result. The getMapRaster method must return a Map containing all
 * seven of the required fields, otherwise the front end code will probably
 * not draw the output correctly.
 */
public class Rasterer {
	public static final double ROOT_ULLAT = 37.892195547244356, ROOT_ULLON = -122.2998046875,
            ROOT_LRLAT = 37.82280243352756, ROOT_LRLON = -122.2119140625;
    public static final int TILE_SIZE = 256;
    // Recommended: QuadTree instance variable. You'll need to make
    //              your own QuadTree since there is no built-in quadtree in Java.

    /** imgRoot is the name of the directory containing the images.
     *  You may not actually need this for your class. */
    public Rasterer(String imgRoot) {
        // YOUR CODE HERE
    }

    /**
     * Takes a user query and finds the grid of images that best matches the query. These
     * images will be combined into one big image (rastered) by the front end. <br>
     * <p>
     *     The grid of images must obey the following properties, where image in the
     *     grid is referred to as a "tile".
     *     <ul>
     *         <li>Has dimensions of at least w by h, where w and h are the user viewport width
     *         and height.</li>
     *         <li>The tiles collected must cover the most longitudinal distance per pixel
     *         (LonDPP) possible, while still covering less than or equal to the amount of
     *         longitudinal distance per pixel in the query box for the user viewport size. </li>
     *         <li>Contains all tiles that intersect the query bounding box that fulfill the
     *         above condition.</li>
     *         <li>The tiles must be arranged in-order to reconstruct the full image.</li>
     *     </ul>
     * </p>
     * @param params Map of the HTTP GET request's query parameters - the query box and
     *               the user viewport width and height.
     *
     * @return A map of results for the front end as specified:
     * "render_grid"   -> String[][], the files to display
     * "raster_ul_lon" -> Number, the bounding upper left longitude of the rastered image <br>
     * "raster_ul_lat" -> Number, the bounding upper left latitude of the rastered image <br>
     * "raster_lr_lon" -> Number, the bounding lower right longitude of the rastered image <br>
     * "raster_lr_lat" -> Number, the bounding lower right latitude of the rastered image <br>
     * "depth"         -> Number, the 1-indexed quadtree depth of the nodes of the rastered image.
     *                    Can also be interpreted as the length of the numbers in the image
     *                    string. <br>
     * "query_success" -> Boolean, whether the query was able to successfully complete. Don't
     *                    forget to set this to true! <br>
     * @see #REQUIRED_RASTER_REQUEST_PARAMS
     */
    static QuadTree mapTree = new QuadTree(ROOT_ULLAT, ROOT_ULLON, ROOT_LRLAT, ROOT_LRLON, "root");

    public Map<String, Object> getMapRaster(Map<String, Double> params) {

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        HashMap<String, Object> rasteredImageParams = new HashMap<>();
        // Call the QuadTree class and build the QuadTree
        // Go to the specified level and retrieve the proper parameters
        double ullat = params.get("ullat");
        double ullon = params.get("ullon");
        double lrlat = params.get("lrlat");
        double lrlon = params.get("lrlon");
        double windowWidth = params.get("w");
        double windowHeight = params.get("h");
        double queryDistancePerPixel = (lrlon - ullon) / windowWidth;
        // We want the tileDistancePerPixel to be smaller than queryDistancePerPixel
        ArrayList<QuadTree.QTreeNode> list =  mapTree.findRasterBox(mapTree.getRoot(), ullat, ullon, lrlat, lrlon, queryDistancePerPixel);
        int row = mapTree.getRow();
        int col = mapTree.getCol();
        // Get all the tiles and concatenate them into one single BufferedImage
        rasteredImageParams.put("raster_ul_lon", list.get(0).getULLON());
        rasteredImageParams.put("raster_ul_lat", list.get(0).getULLAT());
        rasteredImageParams.put("raster_lr_lat", list.get(list.size() - 1).getLRLAT());
        rasteredImageParams.put("raster_lr_lon", list.get(list.size() - 1).getLRLON());
        rasteredImageParams.put("raster_width", col * TILE_SIZE);
        rasteredImageParams.put("raster_height", row * TILE_SIZE);
        rasteredImageParams.put("depth", list.get(0).getDepth());
        rasteredImageParams.put("query_success", true);
        return rasteredImageParams;
    }

}
