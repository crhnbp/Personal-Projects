//
//  priceController.swift
//  envprojnew
//
//  Created by Frances Lin on 8/16/17.
//  Copyright © 2017 Frances Lin. All rights reserved.
//

import Foundation
import UIKit

class priceController: UIViewController {
    
    @IBOutlet weak var low: UILabel!
    @IBOutlet weak var high: UILabel!
    @IBOutlet weak var avg: UILabel!
    @IBOutlet weak var vol: UILabel!
    @IBOutlet weak var lowcost: UILabel!
    @IBOutlet weak var highcost: UILabel!
    @IBOutlet weak var avgcost: UILabel!
    @IBAction func backop(_ sender: Any) {
        self.performSegue(withIdentifier: "backOp", sender: self)
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
        
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    
}
