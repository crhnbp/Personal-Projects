//
//  basicController.swift
//  envprojnew
//
//  Created by Frances Lin on 8/16/17.
//  Copyright © 2017 Frances Lin. All rights reserved.
//

import Foundation
import UIKit

class basicController: UIViewController {
    
    
    @IBAction func backop2(_ sender: Any) {
        self.performSegue(withIdentifier: "backTo1", sender: self)
    }
    @IBOutlet weak var instructions: UILabel!
    override func viewDidLoad() {
        super.viewDidLoad()
        if tableViewController.Cost.num == 0 {
            instructions.text = "制度控制措施时指地方政府或环保部门通过法律或者行政手段来限制人体和生态要素在污染场地中的暴露以保证修复工程的顺利完成和实现潜在污染暴露最小化的方法。。。"
        } else if tableViewController.Cost.num == 1 {
            instructions.text = "制度控制措施也包括必要时对场地内的土壤定期监测，以保证修复工程的顺利完成和实现潜在污染暴露最小化的方法。。。"
        }
        
        // Do any additional setup after loading the view, typically from a nib.
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    
}
