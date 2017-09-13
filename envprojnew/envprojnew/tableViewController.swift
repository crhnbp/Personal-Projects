//
//  tableViewController.swift
//  envprojnew
//
//  Created by Frances Lin on 8/17/17.
//  Copyright © 2017 Frances Lin. All rights reserved.
//

import Foundation
import UIKit

class tableViewController: UITableViewController {
    
    @IBAction func backToRem(_ sender: Any) {
        self.performSegue(withIdentifier: "backToRem", sender: self)
    }
    @IBAction func solid(_ sender: Any) {
        Cost.low = RemOptions1Controller.Data.nums[0]
        Cost.high = RemOptions1Controller.Data.nums[1]
        Cost.avg = RemOptions1Controller.Data.nums[2]
        Cost.lowcost = RemOptions1Controller.Data.nums[3]
        Cost.highcost = RemOptions1Controller.Data.nums[4]
        Cost.avgcost = RemOptions1Controller.Data.nums[5]
        Cost.design = 0
        Cost.install = 0
        self.performSegue(withIdentifier: "toFinal", sender: self)
    }
    
    @IBAction func perme(_ sender: Any) {
        Cost.low = RemOptions1Controller.Data.nums[32]
        Cost.high = RemOptions1Controller.Data.nums[33]
        Cost.avg = RemOptions1Controller.Data.nums[34]
        Cost.lowcost = RemOptions1Controller.Data.nums[35]
        Cost.highcost = RemOptions1Controller.Data.nums[36]
        Cost.avgcost = RemOptions1Controller.Data.nums[37]
        Cost.design = 0
        Cost.install = 0
        self.performSegue(withIdentifier: "toFinal", sender: self)
    }
    @IBAction func contain(_ sender: Any) {
    }
    @IBAction func landfill(_ sender: Any) {
        Cost.low = RemOptions1Controller.Data.nums[135]
        Cost.high = RemOptions1Controller.Data.nums[136]
        Cost.avg = RemOptions1Controller.Data.nums[137]
        Cost.lowcost = RemOptions1Controller.Data.nums[138]
        Cost.highcost = RemOptions1Controller.Data.nums[139]
        Cost.avgcost = RemOptions1Controller.Data.nums[140]
        Cost.design = 0
        Cost.install = 0
        self.performSegue(withIdentifier: "toFinal", sender: self)
    }
    @IBAction func monitor(_ sender: Any) {
        Cost.num = 1
        self.performSegue(withIdentifier: "toInst", sender: self)
    }
    @IBAction func admin(_ sender: Any) {
        Cost.num = 0
        self.performSegue(withIdentifier: "toInst", sender: self)
    }
    @IBAction func incin(_ sender: Any) {
        Cost.low = RemOptions1Controller.Data.nums[87]
        Cost.high = RemOptions1Controller.Data.nums[88]
        Cost.avg = RemOptions1Controller.Data.nums[89]
        Cost.lowcost = RemOptions1Controller.Data.nums[90]
        Cost.highcost = RemOptions1Controller.Data.nums[91]
        Cost.avgcost = RemOptions1Controller.Data.nums[92]
        Cost.design = 0
        Cost.install = 0
        self.performSegue(withIdentifier: "toFinal", sender: self)
    }
    @IBAction func soilw(_ sender: Any) {
        Cost.low = RemOptions1Controller.Data.nums[63]
        Cost.high = RemOptions1Controller.Data.nums[64]
        Cost.avg = RemOptions1Controller.Data.nums[65]
        Cost.lowcost = RemOptions1Controller.Data.nums[66]
        Cost.highcost = RemOptions1Controller.Data.nums[67]
        Cost.avgcost = RemOptions1Controller.Data.nums[68]
        Cost.design = 0
        Cost.install = 0
        self.performSegue(withIdentifier: "toFinal", sender: self)
    }
    @IBAction func multi(_ sender: Any) {
        Cost.low = RemOptions1Controller.Data.nums[24]
        Cost.high = RemOptions1Controller.Data.nums[25]
        Cost.avg = RemOptions1Controller.Data.nums[26]
        Cost.lowcost = RemOptions1Controller.Data.nums[27]
        Cost.highcost = RemOptions1Controller.Data.nums[28]
        Cost.avgcost = RemOptions1Controller.Data.nums[29]
        Cost.design = 0
        Cost.install = 0
        self.performSegue(withIdentifier: "toFinal", sender: self)
    }
    @IBAction func chemox2(_ sender: Any) {
        Cost.low = RemOptions1Controller.Data.nums[111]
        Cost.high = RemOptions1Controller.Data.nums[112]
        Cost.avg = RemOptions1Controller.Data.nums[113]
        Cost.lowcost = RemOptions1Controller.Data.nums[114]
        Cost.highcost = RemOptions1Controller.Data.nums[115]
        Cost.avgcost = RemOptions1Controller.Data.nums[116]
        Cost.design = 0
        Cost.install = 0
        self.performSegue(withIdentifier: "toFinal", sender: self)
    }
    @IBAction func exca(_ sender: Any) {
        Cost.low = RemOptions1Controller.Data.nums[119]
        Cost.high = RemOptions1Controller.Data.nums[120]
        Cost.avg = RemOptions1Controller.Data.nums[121]
        Cost.lowcost = RemOptions1Controller.Data.nums[122]
        Cost.highcost = RemOptions1Controller.Data.nums[123]
        Cost.avgcost = RemOptions1Controller.Data.nums[124]
        Cost.design = 0
        Cost.install = 0
        self.performSegue(withIdentifier: "toFinal", sender: self)
    }
    @IBAction func biopile(_ sender: Any) {
        Cost.low = RemOptions1Controller.Data.nums[95]
        Cost.high = RemOptions1Controller.Data.nums[96]
        Cost.avg = RemOptions1Controller.Data.nums[97]
        Cost.lowcost = RemOptions1Controller.Data.nums[98]
        Cost.highcost = RemOptions1Controller.Data.nums[99]
        Cost.avgcost = RemOptions1Controller.Data.nums[100]
        Cost.design = 0
        Cost.install = 0
        self.performSegue(withIdentifier: "toFinal", sender: self)
    }
    @IBAction func solid2(_ sender: Any) {
        Cost.low = RemOptions1Controller.Data.nums[103]
        Cost.high = RemOptions1Controller.Data.nums[104]
        Cost.avg = RemOptions1Controller.Data.nums[105]
        Cost.lowcost = RemOptions1Controller.Data.nums[106]
        Cost.highcost = RemOptions1Controller.Data.nums[107]
        Cost.avgcost = RemOptions1Controller.Data.nums[108]
        Cost.design = 0
        Cost.install = 0
        self.performSegue(withIdentifier: "toFinal", sender: self)
    }
    @IBAction func pump(_ sender: Any) {
        Cost.low = RemOptions1Controller.Data.nums[16]
        Cost.high = RemOptions1Controller.Data.nums[17]
        Cost.avg = RemOptions1Controller.Data.nums[18]
        Cost.lowcost = RemOptions1Controller.Data.nums[19]
        Cost.highcost = RemOptions1Controller.Data.nums[20]
        Cost.avgcost = RemOptions1Controller.Data.nums[21]
        Cost.design = 0
        Cost.install = 0
        self.performSegue(withIdentifier: "toFinal", sender: self)
    }
    @IBAction func cempla(_ sender: Any) {
        Cost.low = RemOptions1Controller.Data.nums[127]
        Cost.high = RemOptions1Controller.Data.nums[128]
        Cost.avg = RemOptions1Controller.Data.nums[129]
        Cost.lowcost = RemOptions1Controller.Data.nums[130]
        Cost.highcost = RemOptions1Controller.Data.nums[131]
        Cost.avgcost = RemOptions1Controller.Data.nums[132]
        Cost.design = 0
        Cost.install = 0
        self.performSegue(withIdentifier: "toFinal", sender: self)
    }
    @IBAction func chemex(_ sender: Any) {
        Cost.low = RemOptions1Controller.Data.nums[71]
        Cost.high = RemOptions1Controller.Data.nums[72]
        Cost.avg = RemOptions1Controller.Data.nums[73]
        Cost.lowcost = RemOptions1Controller.Data.nums[74]
        Cost.highcost = RemOptions1Controller.Data.nums[75]
        Cost.avgcost = RemOptions1Controller.Data.nums[76]
        Cost.design = 0
        Cost.install = 0
        self.performSegue(withIdentifier: "toFinal", sender: self)
    }
    @IBAction func thermde(_ sender: Any) {
        Cost.low = RemOptions1Controller.Data.nums[79]
        Cost.high = RemOptions1Controller.Data.nums[80]
        Cost.avg = RemOptions1Controller.Data.nums[81]
        Cost.lowcost = RemOptions1Controller.Data.nums[82]
        Cost.highcost = RemOptions1Controller.Data.nums[83]
        Cost.avgcost = RemOptions1Controller.Data.nums[84]
        Cost.design = 0
        Cost.install = 0
        self.performSegue(withIdentifier: "toFinal", sender: self)
    }
    @IBAction func bioven(_ sender: Any) {
        Cost.low = RemOptions1Controller.Data.nums[39]
        Cost.high = RemOptions1Controller.Data.nums[40]
        Cost.avg = RemOptions1Controller.Data.nums[41]
        Cost.lowcost = RemOptions1Controller.Data.nums[42]
        Cost.highcost = RemOptions1Controller.Data.nums[43]
        Cost.avgcost = RemOptions1Controller.Data.nums[44]
        Cost.design = 0
        Cost.install = 0
        self.performSegue(withIdentifier: "toFinal", sender: self)
    }
    @IBAction func phyto(_ sender: Any) {
        Cost.low = RemOptions1Controller.Data.nums[47]
        Cost.high = RemOptions1Controller.Data.nums[48]
        Cost.avg = RemOptions1Controller.Data.nums[49]
        Cost.lowcost = RemOptions1Controller.Data.nums[50]
        Cost.highcost = RemOptions1Controller.Data.nums[51]
        Cost.avgcost = RemOptions1Controller.Data.nums[52]
        Cost.design = 0
        Cost.install = 0
        self.performSegue(withIdentifier: "toFinal", sender: self)
    }
    @IBAction func airsp(_ sender: Any) {
        Cost.low = RemOptions1Controller.Data.nums[0]
        Cost.high = RemOptions1Controller.Data.nums[1]
        Cost.avg = RemOptions1Controller.Data.nums[2]
        Cost.lowcost = RemOptions1Controller.Data.nums[3]
        Cost.highcost = RemOptions1Controller.Data.nums[4]
        Cost.avgcost = RemOptions1Controller.Data.nums[5]
        Cost.design = 0
        Cost.install = 0
        self.performSegue(withIdentifier: "toFinal", sender: self)
    }
    @IBAction func chemox(_ sender: Any) {
        if SiteTypeViewController.Properties.Land == false {
            Cost.low = RemOptions1Controller.Data.nums[8]
            Cost.high = RemOptions1Controller.Data.nums[9]
            Cost.avg = RemOptions1Controller.Data.nums[10]
            Cost.lowcost = RemOptions1Controller.Data.nums[11]
            Cost.highcost = RemOptions1Controller.Data.nums[12]
            Cost.avgcost = RemOptions1Controller.Data.nums[13]
            Cost.design = 0
            Cost.install = 0
            self.performSegue(withIdentifier: "toFinal", sender: self)
        } else if SiteTypeViewController.Properties.Land == true {
            Cost.low = RemOptions1Controller.Data.nums[55]
            Cost.high = RemOptions1Controller.Data.nums[56]
            Cost.avg = RemOptions1Controller.Data.nums[57]
            Cost.lowcost = RemOptions1Controller.Data.nums[58]
            Cost.highcost = RemOptions1Controller.Data.nums[59]
            Cost.avgcost = RemOptions1Controller.Data.nums[60]
            Cost.design = 0
            Cost.install = 0
            self.performSegue(withIdentifier: "toFinal", sender: self)
        }
    }
    @IBAction func enhanbio(_ sender: Any) {
        Cost.low = RemOptions1Controller.Data.nums[31]
        Cost.high = RemOptions1Controller.Data.nums[32]
        Cost.avg = RemOptions1Controller.Data.nums[33]
        Cost.lowcost = RemOptions1Controller.Data.nums[34]
        Cost.highcost = RemOptions1Controller.Data.nums[35]
        Cost.avgcost = RemOptions1Controller.Data.nums[36]
        Cost.design = 0
        Cost.install = 0
        self.performSegue(withIdentifier: "toFinal", sender: self)
    }
    @IBAction func atten(_ sender: Any) {
        Cost.low = RemOptions1Controller.Data.nums[40]
        Cost.high = RemOptions1Controller.Data.nums[41]
        Cost.avg = RemOptions1Controller.Data.nums[42]
        Cost.lowcost = RemOptions1Controller.Data.nums[43]
        Cost.highcost = RemOptions1Controller.Data.nums[44]
        Cost.avgcost = RemOptions1Controller.Data.nums[45]
        Cost.design = 0
        Cost.install = 0
        self.performSegue(withIdentifier: "toFinal", sender: self)
    }
    @IBAction func thermab(_ sender: Any) {
        Cost.low = RemOptions1Controller.Data.nums[23]
        Cost.high = RemOptions1Controller.Data.nums[24]
        Cost.avg = RemOptions1Controller.Data.nums[25]
        Cost.lowcost = RemOptions1Controller.Data.nums[26]
        Cost.highcost = RemOptions1Controller.Data.nums[27]
        Cost.avgcost = RemOptions1Controller.Data.nums[28]
        Cost.design = 0
        Cost.install = 0
        self.performSegue(withIdentifier: "toFinal", sender: self)
    }
    @IBAction func soilvape(_ sender: Any) {
        Cost.low = RemOptions1Controller.Data.nums[8]
        Cost.high = RemOptions1Controller.Data.nums[9]
        Cost.avg = RemOptions1Controller.Data.nums[10]
        Cost.lowcost = RemOptions1Controller.Data.nums[11]
        Cost.highcost = RemOptions1Controller.Data.nums[12]
        Cost.avgcost = RemOptions1Controller.Data.nums[13]
        Cost.designlow = RemOptions1Controller.Data.nums[14]
        Cost.designhigh = RemOptions1Controller.Data.nums[15]
        Cost.designavg = RemOptions1Controller.Data.nums[16]
        Cost.installlow = RemOptions1Controller.Data.nums[17]
        Cost.installhigh = RemOptions1Controller.Data.nums[18]
        Cost.installavg = RemOptions1Controller.Data.nums[19]
        Cost.area = RemOptions1Controller.Data.nums[20]
        Cost.area30 = RemOptions1Controller.Data.nums[21]
        Cost.area90 = RemOptions1Controller.Data.nums[22]
        self.performSegue(withIdentifier: "toSpec", sender: self)
    }
    
    @IBOutlet weak var celli4: UITableViewCell!
    @IBOutlet weak var celli3: UITableViewCell!
    @IBOutlet weak var celli2: UITableViewCell!
    @IBOutlet weak var celli: UITableViewCell!
    @IBOutlet weak var cell25: UITableViewCell!
    @IBOutlet weak var cell24: UITableViewCell!
    @IBOutlet weak var cell23: UITableViewCell!
    @IBOutlet weak var cell22: UITableViewCell!
    @IBOutlet weak var cell21: UITableViewCell!
    @IBOutlet weak var cell19: UITableViewCell!
    @IBOutlet weak var cell20: UITableViewCell!
    @IBOutlet weak var cell1: UITableViewCell!
    @IBOutlet weak var cell11: UITableViewCell!
    @IBOutlet weak var cell18: UITableViewCell!
    @IBOutlet weak var cell17: UITableViewCell!
    @IBOutlet weak var cell16: UITableViewCell!
    @IBOutlet weak var cell15: UITableViewCell!
    @IBOutlet weak var cell14: UITableViewCell!
    @IBOutlet weak var cell13: UITableViewCell!
    @IBOutlet weak var cell12: UITableViewCell!
    @IBOutlet weak var cell10: UITableViewCell!
    @IBOutlet weak var cell8: UITableViewCell!
    @IBOutlet weak var cell9: UITableViewCell!
    @IBOutlet weak var cell7: UITableViewCell!
    @IBOutlet weak var cell6: UITableViewCell!
    @IBOutlet weak var cell5: UITableViewCell!
    @IBOutlet weak var cell4: UITableViewCell!
    @IBOutlet weak var cell2: UITableViewCell!
    
    @IBOutlet weak var cell3: UITableViewCell!
    @IBOutlet var table1: UITableView!
    override func viewDidLoad() {
        super.viewDidLoad()
        
        // Do any additional setup after loading the view, typically from a nib.
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    override func tableView(_ tableView: UITableView, heightForRowAt indexPath: IndexPath) -> CGFloat {
        var cell = super.tableView(tableView, cellForRowAt: indexPath)
        if SiteTypeViewController.Properties.Land == true && LandOptionsController.Choice.Category == "0" {
            if cell != self.celli && cell != self.celli2 && cell != self.celli3 && cell != self.cell4 && cell != self.cell1 && cell != self.cell9 && cell != self.cell10 && cell != self.cell20 && cell != self.cell21 && cell != self.cell22 && cell != self.cell23{
                return 0
            }
            
        } else if SiteTypeViewController.Properties.Land == true && LandOptionsController.Choice.Category == "1" {
            if cell != self.celli && cell != self.celli2 && cell != self.celli3 && cell != self.cell4 && cell != self.cell1 && cell != self.cell9 && cell != self.cell10 && cell != self.cell20 && cell != self.cell21 && cell != self.cell22 && cell != self.cell23{
                return 0
            }
    
    } else if SiteTypeViewController.Properties.Land == true && LandOptionsController.Choice.Category == "2" {
            if cell != self.celli && cell != self.celli2 && cell != self.celli3 && cell != self.celli4 && cell != self.cell5 && cell != self.cell16 && cell != self.cell20 && cell != self.cell21 && cell != self.cell22 && cell != self.cell23{
                return 0
            }
    
    } else if SiteTypeViewController.Properties.Land == true && LandOptionsController.Choice.Category == "3" {
            if cell != self.celli && cell != self.celli2 && cell != self.celli3 && cell != self.celli4 && cell != self.cell5 && cell != self.cell16 && cell != self.cell20 && cell != self.cell21 && cell != self.cell22 && cell != self.cell23{
                return 0
            }
    
    // Do any additional setup after loading the view, typically from a nib.
    } else if SiteTypeViewController.Properties.Land == true && LandOptionsController.Choice.Category == "4" {
            if cell != self.celli && cell != self.celli2 && cell != self.celli3 && cell != self.celli4 && cell != self.cell5 && cell != self.cell1 && cell != self.cell2 && cell != self.cell9 && cell != self.cell15 && cell != self.cell20 && cell != self.cell21 && cell != self.cell22 && cell != self.cell23{
                return 0
            }
    
    } else if SiteTypeViewController.Properties.Land == true && LandOptionsController.Choice.Category == "5" {
            if cell != self.celli && cell != self.celli2 && cell != self.celli3 && cell != self.celli4 && cell != self.cell3 && cell != self.cell16 && cell != self.cell11 && cell != self.cell21 && cell != self.cell22 && cell != self.cell23{
                return 0
            }
    
    } else if SiteTypeViewController.Properties.Land == false && LandOptionsController.Choice.Category == "0" {
            if cell != self.celli && cell != self.celli2 && cell != self.celli3 && cell != self.celli4 && cell != self.cell6 && cell != self.cell7 && cell != self.cell13 && cell != self.cell21 && cell != self.cell22 && cell != self.cell25{
                return 0
            }
    
    } else if SiteTypeViewController.Properties.Land == false && LandOptionsController.Choice.Category == "1" {
            if cell != self.celli && cell != self.celli2 && cell != self.celli3 && cell != self.celli4 && cell != self.cell6 && cell != self.cell7 && cell != self.cell13 && cell != self.cell21 && cell != self.cell22 && cell != self.cell25{
                return 0
            }
    
    } else if SiteTypeViewController.Properties.Land == false && LandOptionsController.Choice.Category == "2" {
            if cell != self.celli && cell != self.celli2 && cell != self.celli3 && cell != self.celli4 && cell != self.cell6 && cell != self.cell13 && cell != self.cell21 && cell != self.cell22 && cell != self.cell25{
                return 0
            }
    
    } else if SiteTypeViewController.Properties.Land == false && LandOptionsController.Choice.Category == "3" {
            if cell != self.celli && cell != self.celli2 && cell != self.celli3 && cell != self.celli4 && cell != self.cell6 && cell != self.cell13 && cell != self.cell21 && cell != self.cell22 && cell != self.cell25{
                return 0
            }
    
    } else if SiteTypeViewController.Properties.Land == false && LandOptionsController.Choice.Category == "4" {
            if cell != self.celli && cell != self.celli2 && cell != self.celli3 && cell != self.celli4 && cell != self.cell6 && cell != self.cell7 && cell != self.cell13 && cell != self.cell21 && cell != self.cell22 && cell != self.cell25{
                return 0
            }
    
    } else if SiteTypeViewController.Properties.Land == false && LandOptionsController.Choice.Category == "5" {
            if cell != self.celli && cell != self.celli2 && cell != self.celli3 && cell != self.celli4 && cell != self.cell13 && cell != self.cell21 && cell != self.cell22 && cell != self.cell25{
                return 0
            }
    
    }
    
    
        return super.tableView(tableView, heightForRowAt: indexPath)
    }

    struct Cost {
        static var low = Double()
        static var high = Double()
        static var avg = Double()
        static var lowcost = Double()
        static var highcost = Double()
        static var avgcost = Double()
        static var install = Double()
        static var design = Double()
        static var designlow = Double()
        static var designhigh = Double()
        static var designavg = Double()
        static var installlow = Double()
        static var installhigh = Double()
        static var installavg = Double()
        static var area = Double()
        static var area90 = Double()
        static var area30 = Double()
        static var desc = String()
        static var inst = String()
        static var inst2 = String()
        static var num = Int()
    }
    
    
}
