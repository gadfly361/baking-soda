(ns baking-soda.react-bootstrap)


(def react-bootstrap-tags
  '[Accordion
    Alert
    Badge
    Breadcrumb
    BreadcrumbItem
    Button
    ButtonGroup
    ButtonToolbar
    Carousel
    CarouselItem
    Checkbox
    Clearfix
    Col
    Collapse
    ControlLabel
    Dropdown
    DropdownButton
    Fade
    Form
    FormControl
    FormGroup
    Glyphicon
    Grid
    HelpBlock
    Image
    InputGroup
    Jumbotron
    Label
    ListGroup
    ListGroupItem
    Media
    MenuItem
    Modal
    ModalBody
    ModalFooter
    ModalHeader
    ModalTitle
    Nav
    NavDropdown
    NavItem
    Navbar
    NavbarBrand
    Overlay
    OverlayTrigger
    PageHeader
    Pager
    Pagination
    Panel
    PanelGroup
    Popover
    ProgressBar
    Radio
    ResponsiveEmbed
    Row
    SafeAnchor
    SplitButton
    Tab
    TabContainer
    TabContent
    TabPane
    Table
    Tabs ;;
    Thumbnail
    Tooltip
    Well])


(defn create-react-bootstrap-component [tag]
  `(def ~tag (reagent.core/adapt-react-class
              (aget js/ReactBootstrap ~(name tag)))))


(defmacro export-react-bootstrap-components []
  `(do ~@(map create-react-bootstrap-component
              react-bootstrap-tags)))
