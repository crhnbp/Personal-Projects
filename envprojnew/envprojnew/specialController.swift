//
//  specialController.swift
//  envprojnew
//
//  Created by Frances Lin on 8/17/17.
//  Copyright © 2017 Frances Lin. All rights reserved.
//

import Foundation
import UIKit

class specialController: UIViewController {
    
    @IBOutlet weak var area: UILabel!
    @IBOutlet weak var area90: UILabel!
    @IBOutlet weak var area30: UILabel!
    @IBOutlet weak var low: UILabel!
    @IBOutlet weak var high: UILabel!
    @IBOutlet weak var avg: UILabel!
    @IBOutlet weak var vol: UILabel!
    @IBOutlet weak var lowcost: UILabel!
    @IBOutlet weak var highcost: UILabel!
    @IBOutlet weak var avgcost: UILabel!
    @IBOutlet weak var lowinst: UILabel!
    @IBOutlet weak var highinst: UILabel!
    @IBOutlet weak var avginst: UILabel!
    @IBOutlet weak var lowdes: UILabel!
    @IBOutlet weak var highdes: UILabel!
    @IBOutlet weak var avgdes: UILabel!
    @IBAction func backop3(_ sender: Any) {
        self.performSegue(withIdentifier: "backOp3", sender: self)
    }
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        low.text = "\(tableViewController.Cost.low)"
        high.text = "\(tableViewController.Cost.high)"
        avg.text = "\(tableViewController.Cost.avg)"
        vol.text = "\(RemOptions1Controller.Data.size)"
        lowcost.text = "\(tableViewController.Cost.lowcost)"
        highcost.text = "\(tableViewController.Cost.highcost)"
        avgcost.text = "\(tableViewController.Cost.avgcost)"
        area.text = "\(tableViewController.Cost.area)"
        area90.text = "\(tableViewController.Cost.area90)"
        area30.text = "\(tableViewController.Cost.area30)"
        lowinst.text = "\(tableViewController.Cost.installlow)"
        highinst.text = "\(tableViewController.Cost.installhigh)"
        avginst.text = "\(tableViewController.Cost.installavg)"
        lowdes.text = "\(tableViewController.Cost.designlow)"
        highdes.text = "\(tableViewController.Cost.designhigh)"
        avgdes.text = "\(tableViewController.Cost.designavg)"
        
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    
}
