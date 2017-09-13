//
//  Options1Controller.swift
//  envprojnew
//
//  Created by Frances Lin on 8/15/17.
//  Copyright © 2017 Frances Lin. All rights reserved.
//

import Foundation
import UIKit

class Options1Controller: UIViewController {
    
    
    
    @IBOutlet weak var table1: UITableView!
    
    @IBAction func backdim(_ sender: Any) {
        self.performSegue(withIdentifier: "backDim", sender: self)
    }
    @IBAction func solidval(_ sender: Any) {
        Cost.low = RemOptions1Controller.Data.nums[0]
        Cost.high = RemOptions1Controller.Data.nums[1]
        Cost.avg = RemOptions1Controller.Data.nums[2]
        Cost.lowcost = RemOptions1Controller.Data.nums[3]
        Cost.highcost = RemOptions1Controller.Data.nums[4]
        Cost.avgcost = RemOptions1Controller.Data.nums[5]
        Cost.design = 0
        Cost.install = 0
        self.performSegue(withIdentifier: "toTable", sender: self)

        
    }
    @IBAction func soilvapeval(_ sender: Any) {
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
    
    @IBAction func thermabval(_ sender: Any) {
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
    @IBAction func enhanbioval(_ sender: Any) {
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
    @IBAction func bioventval(_ sender: Any) {
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
    @IBAction func phytoval(_ sender: Any) {
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
    @IBAction func chemoxval(_ sender: Any) {
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
    @IBAction func airspval(_ sender: Any) {
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
    @IBAction func soilwaval(_ sender: Any) {
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
    @IBAction func chemexval(_ sender: Any) {
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
    
    @IBAction func thermdeval(_ sender: Any) {
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
    @IBAction func incinval(_ sender: Any) {
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
    @IBAction func cemval(_ sender: Any) {
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
    @IBAction func pumpval(_ sender: Any) {
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
    @IBAction func biopval(_ sender: Any) {
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
    @IBAction func solid2val(_ sender: Any) {
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
    @IBAction func chemoxval2(_ sender: Any) {
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
    @IBAction func excaval(_ sender: Any) {
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
    @IBAction func multival(_ sender: Any) {
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
    @IBAction func adminval(_ sender: Any) {
        Cost.num = 0
        self.performSegue(withIdentifier: "toInst", sender: self)
    }
    @IBAction func monitorval(_ sender: Any) {
        Cost.num = 1
        self.performSegue(withIdentifier: "toInst", sender: self)
    }
    @IBAction func containval(_ sender: Any) {
    }
    @IBAction func permeval(_ sender: Any) {
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
    @IBAction func attenval(_ sender: Any) {
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
    @IBAction func landfillval(_ sender: Any) {
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
    override func viewDidLoad() {
        super.viewDidLoad()
        if SiteTypeViewController.Properties.Land == true && LandOptionsController.Choice.Category == "0" {
            //table1.deleteSections([0], with: UITableViewRowAnimation .fade)
           
            
        } else if SiteTypeViewController.Properties.Land == true && LandOptionsController.Choice.Category == "1" {
            
        } else if SiteTypeViewController.Properties.Land == true && LandOptionsController.Choice.Category == "2" {
            
        } else if SiteTypeViewController.Properties.Land == true && LandOptionsController.Choice.Category == "3" {
            
        // Do any additional setup after loading the view, typically from a nib.
        } else if SiteTypeViewController.Properties.Land == true && LandOptionsController.Choice.Category == "4" {
        
        } else if SiteTypeViewController.Properties.Land == true && LandOptionsController.Choice.Category == "5" {
           
        } else if SiteTypeViewController.Properties.Land == false && LandOptionsController.Choice.Category == "0" {
            
        } else if SiteTypeViewController.Properties.Land == false && LandOptionsController.Choice.Category == "1" {
          
        } else if SiteTypeViewController.Properties.Land == false && LandOptionsController.Choice.Category == "2" {
            
        } else if SiteTypeViewController.Properties.Land == false && LandOptionsController.Choice.Category == "3" {
          
        } else if SiteTypeViewController.Properties.Land == false && LandOptionsController.Choice.Category == "4" {
           
        } else if SiteTypeViewController.Properties.Land == false && LandOptionsController.Choice.Category == "5" {
           
        }
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
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

extension Options1Controller: UITableViewDataSource, UITableViewDelegate {
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return 2
    }
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "cell1") as! tableCell
        return cell
    }
    
}
