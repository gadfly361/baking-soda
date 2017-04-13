(ns baking-soda.reactstrap)


(def reactstrap-tags
  '[Alert
    Badge
    Breadcrumb
    BreadcrumbItem
    Button
    ButtonDropdown
    ButtonGroup
    ButtonToolbar
    Card
    CardBlock
    CardColumns
    CardDeck
    CardFooter
    CardGroup
    CardHeader
    CardImg
    CardImgOverlay
    CardLink
    CardSubtitle
    CardText
    CardTitle
    Col
    Collapse
    Container
    Dropdown
    DropdownItem
    DropdownMenu
    DropdownToggle
    Fade
    Form
    FormFeedback
    FormGroup
    FormText
    Input
    InputGroup
    InputGroupAddon
    InputGroupButton
    Jumbotron
    Label
    ListGroup
    ListGroupItem
    ListGroupItemHeading
    ListGroupItemText
    Media
    Modal
    ModalBody
    ModalFooter
    ModalHeader
    Nav
    NavDropdown
    NavItem
    NavLink
    Navbar
    NavbarBrand
    NavbarToggler
    Pagination
    PaginationItem
    PaginationLink
    Popover
    PopoverContent
    PopoverTitle
    Progress
    Row
    TabContent
    TabPane
    Table
    TetherContent
    Tooltip
    UncontrolledAlert
    UncontrolledButtonDropdown
    UncontrolledDropdown
    UncontrolledNavDropdown
    ;; UncontrolledPopover
    UncontrolledTooltip
    ])


(defn create-reactstrap-component [tag]
  `(def ~tag (reagent.core/adapt-react-class
              (aget js/Reactstrap ~(name tag)))))


(defmacro export-reactstrap-components []
  `(do ~@(map create-reactstrap-component
              reactstrap-tags)))
